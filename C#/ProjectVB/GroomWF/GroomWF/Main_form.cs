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
using static System.Windows.Forms.VisualStyles.VisualStyleElement;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.Button;

namespace GroomWF
{
    public partial class Main_form : Form
    {
        // 어드민 정보
        int emp_num;
        // 선택 예약 번호
        int res_num;
        // 선택 예약 상태
        int res_status = 0;
        // 조건부
        string where;

        // DB 정보
        string uri = "121.175.38.138";
        string port = "3306";
        string database = "groom";
        string user = "groom";
        string dbPassword = "Groom@123";
        string conn = "";


        public Main_form(int emp_num)
        {
            InitializeComponent();

            // 이거 관리자 번호
            this.emp_num = emp_num;

            conn = $"Server={uri};Port={port};Database={database};Uid={user};Pwd={dbPassword};AllowPublicKeyRetrieval=true;allow user variables=true;";

            // 검색결과 함수 호출
            SelectQuery();

            // 이벤트 등록하기
            radioButton1.CheckedChanged += RadioButton_Changed;
            radioButton2.CheckedChanged += RadioButton_Changed;
            radioButton3.CheckedChanged += RadioButton_Changed;

        }

        // 예약 상태 한글 반환
        private string CheckStatus(int res_status)
        {
            string status;

            switch (res_status)
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
            return status;
        }

        // 조건부 컬럼명 반환
        private string CheckWhere(string SQLwhere)
        {
            string where;

            switch (SQLwhere)
            {
                case "예약자":
                    where = "f.u_name";
                    break;
                case "연락처":
                    where = "f.u_phone";
                    break;
                default:
                    where = "";
                    break;
            }
            return where;
        }

        // 하이픈 넣기

        private string PhoneNumber(string phone)
        {
            string hyphen;
            if (phone.Length == 11)
            {
                hyphen = phone.Insert(3, "-");
                hyphen = hyphen.Insert(8, "-");
            }
            else
            {
                hyphen = phone.Insert(3, "-");
                hyphen = hyphen.Insert(7, "-");
            }
            return hyphen;
        }
        private void SelectQuery()
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

                                status = CheckStatus(Convert.ToInt32(reader["res_status"]));

                                // 날짜랑 시간은 합쳐서 표기
                                string resDateTime = $"{date} {time}";
                                // 상품도 합쳐서 표기 상품종류만 []로 표기
                                string prod = $"[{reader["pro_name"]}] {reader["pet_size"]} {reader["pet_weight"]}";

                                // 전화번호 하이픈 넣기
                                string phone = reader["u_phone"].ToString();

                                string phoneNumber = PhoneNumber(phone);

                                // 리스트뷰에 값넣기
                                ListViewItem item = new ListViewItem();
                                item.Text = reader["res_num"].ToString();
                                item.SubItems.Add(resDateTime);
                                item.SubItems.Add(prod);
                                item.SubItems.Add(reader["u_name"].ToString());
                                item.SubItems.Add(phoneNumber);
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

        // 조건부 검색용 @오버로딩
        private void SelectQuery(String SQLQuery)
        {
            try
            {
                using (MySqlConnection mysql = new MySqlConnection(conn))
                {
                    mysql.Open();

                    using (MySqlCommand command = new MySqlCommand(SQLQuery, mysql))
                    {
                        // 파라미터에 추가
                        command.Parameters.AddWithValue("@emp_num", this.emp_num);
                        command.Parameters.AddWithValue("@inputVal", "%" + search.Text.Replace("-", "") + "%");

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

                                status = CheckStatus(Convert.ToInt32(reader["res_status"]));

                                // 날짜랑 시간은 합쳐서 표기
                                string resDateTime = $"{date} {time}";
                                // 상품도 합쳐서 표기 상품종류만 []로 표기
                                string prod = $"[{reader["pro_name"]}] {reader["pet_size"]} {reader["pet_weight"]}";

                                // 전화번호 하이픈 넣기
                                string phone = reader["u_phone"].ToString();

                                string phoneNumber = PhoneNumber(phone);

                                // 리스트뷰에 값넣기
                                ListViewItem item = new ListViewItem();
                                item.Text = reader["res_num"].ToString();
                                item.SubItems.Add(resDateTime);
                                item.SubItems.Add(prod);
                                item.SubItems.Add(reader["u_name"].ToString());
                                item.SubItems.Add(phoneNumber);
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
        private void Main_form_Load(object sender, EventArgs e)
        {
            //콤보박스 선택
            comboBox1.SelectedIndex = 0;
        }

        // 라디오 버튼 이벤트 받기
        private void RadioButton_Changed(object sender, EventArgs e)
        {
            System.Windows.Forms.RadioButton radio = sender as System.Windows.Forms.RadioButton;

            if (radio.Checked)
            {
                switch (radio.Name)
                {
                    case "radioButton1":
                        res_status = 0;
                        break;
                    case "radioButton2":
                        res_status = 1;
                        break;
                    case "radioButton3":
                        res_status = 2;
                        break;
                }
            }
        }

        // 리스트뷰 이벤트 처리
        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (listView1.SelectedItems.Count > 0)
            {
                ListViewItem selectedItem = listView1.SelectedItems[0];
                this.res_num = Convert.ToInt32(selectedItem.Text);
            }
        }

        // 콤보박스 이벤트처리
        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if(comboBox1.SelectedIndex >= 0)
            {
                this.where = comboBox1.SelectedItem.ToString();
            }
        }

        // 예약상태변경 버튼 처리
        private void status_button_Click(object sender, EventArgs e)
        {
            if (DialogResult.OK == MessageBox.Show($"예약번호 {res_num}을 {CheckStatus(this.res_status)}상태로 변경하시겠습니까?", "경고", MessageBoxButtons.OKCancel))
            {

                try
                {
                    using (MySqlConnection mysql = new MySqlConnection(conn))
                    {
                        mysql.Open();

                        string updateQuery = "UPDATE reservation SET res_status = @status WHERE emp_num = @emp_num AND res_num = @res_num;";

                        using (MySqlCommand command = new MySqlCommand(updateQuery, mysql))
                        {
                            // 파라미터에 추가
                            command.Parameters.AddWithValue("@status", this.res_status);
                            command.Parameters.AddWithValue("@res_num", this.res_num);
                            command.Parameters.AddWithValue("@emp_num", this.emp_num);

                            if (command.ExecuteNonQuery() == 1)
                            {
                                MessageBox.Show("업데이트 성공");
                            }
                            else
                            {
                                MessageBox.Show("업데이트에 문제 발생");
                            }

                            SelectQuery();
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

        // 전체검색
        private void searchAll_button_Click(object sender, EventArgs e)
        {
            SelectQuery();
        }

        // 조건부 검색
        private void search_button_Click(object sender, EventArgs e)
        {
            // 컬럼명 문자열 보간사용
            string selectQuery = "SELECT a.res_num, a.res_day, a.res_time, b.pro_name, c.pet_size, b.pet_weight, f.u_name, f.u_phone, " +
                     "a.res_status FROM reservation a JOIN product2 b on a.pro_id2 = b.pro_id2 " +
                     "JOIN product1 c on a.pro_id1 = c.pro_id1 " +
                     "JOIN store d on a.s_num = d.s_num JOIN employees e on a.emp_num = e.emp_num " +
                     "JOIN user2 f ON a.u_num = f.u_num " +
                     "WHERE a.emp_num = @emp_num AND " +
                     $"{CheckWhere(this.where)} LIKE @inputVal " +
                     "ORDER BY a.res_num desc;";

            SelectQuery(selectQuery);
        }
    }
}



