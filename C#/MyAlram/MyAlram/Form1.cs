using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MyAlram
{
    public partial class Form1 : Form
    {
        // 전역변수 선언
        Boolean set = false;
        String path = null;
        int hour;
        int minute;
        int second;

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {   
            // 폼 로드시 시각 표시
            label_time.Text = "현재시각 : " + DateTime.Now.ToLongTimeString();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            label_time.Text = "현재시각 : " + DateTime.Now.ToLongTimeString();
        }

        private void button_cmd_Click(object sender, EventArgs e)
        {
            System.Diagnostics.Process.Start("cmd");
        }

        private void button_panel_Click(object sender, EventArgs e)
        {
            System.Diagnostics.Process.Start("control");
        }
    }
}
