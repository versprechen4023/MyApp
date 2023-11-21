using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Media;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using WMPLib;

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
        WindowsMediaPlayer wmp;

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

        private void button_load_Click(object sender, EventArgs e)
        {
            alram_file.InitialDirectory = "C:\\";
            if(alram_file.ShowDialog() == DialogResult.OK)
            {
                path = alram_file.FileName;
                // 특이하게도 배열로 받는다
                alram_name.Text = path.Split('\\')[path.Split('\\').Length - 1];
                // mp3를 실행시키기위한 객체생성
                wmp = new WindowsMediaPlayer();
                wmp.URL = path;
                // 왜 자동으로 실행될까 원래 그런건감
                wmp.controls.stop();
            }

        }

        private void alram_play_Click(object sender, EventArgs e)
        {   
            if(path == null)
            {
                MessageBox.Show("알람음이 선택되지 않았습니다");
            } else
            {
                wmp.controls.play();
            }
        }

        private void alram_stop_Click(object sender, EventArgs e)
        {
            if (path == null)
            {
                MessageBox.Show("알람음이 선택되지 않았습니다");
            } else
            {
                wmp.controls.stop();
            }
        }
    }
}
