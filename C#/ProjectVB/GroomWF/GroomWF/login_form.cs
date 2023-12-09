using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MySql.Data.MySqlClient;
using System.Security.Cryptography;
using System.Data.SqlTypes;
using System.Collections;
using static System.Net.WebRequestMethods;
using Org.BouncyCastle.Utilities.Encoders;

namespace GroomWF
{
    public partial class login_form : Form
    {
        // DB 정보
        string uri = "121.175.38.138";
        string port = "3306";
        string database = "groom";
        string user = "groom";
        string dbPassword = "Groom@123";
        string conn = "";

        // 솔트 계산 함수 자바할때 getByte로 할껄...
        private byte[] HexToBytes(string hex)
        {
            int hexLength = hex.Length;
            byte[] data = new byte[hexLength / 2];
            for (int i = 0; i < hexLength; i += 2)
            {
                data[i / 2] = (byte)((Convert.ToInt32(hex[i].ToString(), 16) << 4) + Convert.ToInt32(hex[i + 1].ToString(), 16));
            }
            return data;
        }

        // 폼종료시 이벤트 받기
        private void Form2_WhenClosed(object sender, FormClosedEventArgs e)
        {
            this.Close();
        }

        public login_form()
        {
            InitializeComponent();

            conn = $"Server={uri};Port={port};Database={database};Uid={user};Pwd={dbPassword};AllowPublicKeyRetrieval=true;allow user variables=true;";
        }

        private void login_form_Load(object sender, EventArgs e)
        {
            //Main_form form2 = new Main_form("2");
            //form2.Show();
            //// 이벤트 저장
            //form2.FormClosed += Form2_WhenClosed;
            //this.Hide();
        }

        private void login_button_Click(object sender, EventArgs e)
        {
            // 사용자 입력값 받기
            string user_id = Id_text.Text;
            string user_pass = pass_text.Text;

            if (user_id == String.Empty)
            {
                MessageBox.Show("아이디를 입력해주세요");
                return;
            } 
            else if(user_pass == String.Empty)
            {
                MessageBox.Show("비밀번호를 입력해주세요");
                return;
            }

            try
            {
                using (MySqlConnection mysql = new MySqlConnection(conn))
                {
                    mysql.Open();

                    string loginQuery = "SELECT * FROM user WHERE u_id = @userId;";

                    using (MySqlCommand command = new MySqlCommand(loginQuery, mysql))
                    {
                        // 파라미터에 추가
                        command.Parameters.AddWithValue("@userId", user_id);

                        using (MySqlDataReader reader = command.ExecuteReader())
                        {
                            if (reader.Read())
                            {
                                // DB에서 정보가져오기
                                string u_pass = reader.GetString("u_pass");
                                string u_salt = reader.GetString("u_salt");
                                string role = reader.GetString("u_role");
                                string emp_num = reader.GetString("u_num");

                                // 계산을 위한 바이트배열 변환
                                byte[] passBytes = System.Text.UTF8Encoding.UTF8.GetBytes(user_pass);
                                byte[] saltBytes = HexToBytes(u_salt);

                                // 알고리즘 시작
                                using (SHA256 sha256 = SHA256.Create())
                                {
                                    // 솔트랑 입력비밀번호 합치기
                                    byte[] bytes = saltBytes.Concat(passBytes).ToArray();

                                    // 해시 계산
                                    byte[] hashBytes = sha256.ComputeHash(bytes);

                                    // 해시값을 문자열로 변환 (32자리 x2 64자리)
                                    StringBuilder sb = new StringBuilder(hashBytes.Length * 2);
                                    for (int i = 0; i < hashBytes.Length; i++)
                                    {
                                        // 여기서 16진수로 변환
                                        sb.Append(BitConverter.ToString(hashBytes, i, 1));
                                    }

                                    // 결과값 소문자로 변환
                                    String userPw = sb.ToString().ToLower();

                                    // 비밀번호 일치시 메인폼 실행
                                    if (u_pass.Equals(userPw) && role.Equals("admin"))
                                    {
                                        Main_form form2 = new Main_form(emp_num);
                                        form2.Show();
                                        // 이벤트 저장
                                        form2.FormClosed += Form2_WhenClosed;
                                        this.Hide();
                                    }
                                    else
                                    {
                                        // 비번 틀렸거나 권한 없을때 처리
                                        MessageBox.Show("아이디 혹은 비밀번호가 일치 하지 않습니다");
                                    }
                                }

                            }
                            else
                            {
                                // 아이디가 존재하지 않을 때 처리
                                MessageBox.Show("아이디 혹은 비밀번호가 일치 하지 않습니다");
                            }
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("서버에 문제가 발생했습니다 관리자에게 문의하십시오");
                Console.WriteLine(ex.Message);
            }

        }
    }
}
