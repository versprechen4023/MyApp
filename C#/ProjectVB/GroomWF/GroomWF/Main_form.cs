using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace GroomWF
{
    public partial class Main_form : Form
    {
        string emp_num;

        // DB 정보
        string uri = "121.175.38.138";
        string port = "3306";
        string database = "groom";
        string user = "groom";
        string dbPassword = "Groom@123";
        string conn = "";


        public Main_form(string emp_num)
        {
            InitializeComponent();

            // 이거 관리자 번호
            this.emp_num = emp_num;

            conn = $"Server={uri};Port={port};Database={database};Uid={user};Pwd={dbPassword};AllowPublicKeyRetrieval=true;allow user variables=true;";
        }

        private void Main_form_Load(object sender, EventArgs e)
        {
            try
            {
                using (MySqlConnection mysql = new MySqlConnection(conn))
                {
                    mysql.Open();

                    string selectQuery = "SELECT a.res_num, a.res_day, a.res_time, b.pro_name, c.pet_size, b.pet_weight, f.u_name, f.u_phone, " +
                     "a.res_status FROM reservation a JOIN product2 b on a.pro_id2 = b.pro_id2 " +
                     "JOIN product1 c on a.pro_id1 = c.pro_id1 " +
                     "JOIN store d on a.s_num = d.s_num JOIN employees e on a.emp_num = e.emp_num " +
                     "JOIN user2 f ON a.u_num = f.u_num " +
                     "WHERE a.emp_num = @emp_num " +
                     "ORDER BY a.res_num desc;";

                    using (MySqlCommand command = new MySqlCommand(selectQuery, mysql))
                    {
                        // 파라미터에 추가
                        command.Parameters.AddWithValue("@emp_num", this.emp_num);

                        using (MySqlDataReader reader = command.ExecuteReader())
                        {
                            listView1.Items.Clear();

                            while (reader.Read())
                            {
                                // 날짜 처리 요일까지만 표기
                                string date = reader["res_day"].ToString();
                                int index = date.IndexOf(")");
                                if (index != -1)
                                {
                                    date = date.Substring(0, index + 1);
                                }

                                // 시간 표기 13:00 과 같은..
                                string time = reader["res_time"].ToString();
                                time = time.Substring(0, time.Length - 3);

                                // 상태가 숫자라 숫자에 따라 한글로 변환
                                string status = "";
                                switch (Convert.ToInt32(reader["res_status"]))
                                {
                                    case 0:
                                        status = "대기";
                                        break;
                                    case 1:
                                        status = "완료";
                                        break;
                                    case 2:
                                        status = "취소";
                                        break;
                                    default:
                                        status = "몰루";
                                        break;
                                }

                                // 날짜랑 시간은 합쳐서 표기
                                string resDateTime = $"{date} {time}";
                                // 상품도 합쳐서 표기 상품종류만 []로 표기
                                string prod = $"[{reader["pro_name"]}] {reader["pet_size"]} {reader["pet_weight"]}";

                                // 리스트뷰에 값넣기
                                ListViewItem item = new ListViewItem();
                                item.Text = reader["res_num"].ToString();
                                item.SubItems.Add(resDateTime);
                                item.SubItems.Add(prod);
                                item.SubItems.Add(reader["u_name"].ToString());
                                item.SubItems.Add(reader["u_phone"].ToString());
                                item.SubItems.Add(status);

                                listView1.Items.Add(item);

                            }

                        }
                    }
                }
            }
            catch (Exception ex)
            {
                //MessageBox.Show("서버에 문제가 발생했습니다 관리자에게 문의하십시오");
                MessageBox.Show(ex.Message);
                Console.WriteLine(ex.Message);
            }

        }

    }
    
}



