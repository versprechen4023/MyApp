using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics.PerformanceData;
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

        // 시각표시
        private void timer1_Tick(object sender, EventArgs e)
        {
            label_time.Text = "현재시각 : " + DateTime.Now.ToLongTimeString();
        }

        // 알람 타이머
        private void alram_timer_Tick(object sender, EventArgs e)
        {
            label_alram.Text = "알람까지 " + hour + "시 " + minute + "분 " +second+ "초 남음";
            // 위치 잡아주기
            label_alram.Location = new System.Drawing.Point(10, 67);
            // 시간처리 로직 수행
            if (second > 0)
            {
                second--;
            }
            else
            {
                if(minute > 0)
                {
                    minute--;
                }
                else if(hour > 0 && minute <= 0)
                {
                    hour--;
                    minute = 59;
                } else
                {   
                    // 시간 다 끝나면 종료
                    alram_timer.Stop();
                    // 알람 불린 펄스
                    set = false;
                    // 알람음 실행
                    wmp.controls.play();
                    // 기본 텍스트 되돌리기
                    label_alram.Text = "알람 설정 되지 않음";
                    label_alram.Location = new System.Drawing.Point(45, 68);

                    if (DialogResult.OK == MessageBox.Show("알람이 울립니다.", "알림", MessageBoxButtons.OK))
                    {
                        wmp.controls.stop();
                    }
                }
                second = 59;
            }

        }

        // 프로그램 실행 기능들
        private void button_cmd_Click(object sender, EventArgs e)
        {
            System.Diagnostics.Process.Start("cmd");
        }

        private void button_panel_Click(object sender, EventArgs e)
        {
            System.Diagnostics.Process.Start("control");
        }


        private void button_note_Click(object sender, EventArgs e)
        {
            System.Diagnostics.Process.Start("notepad");
        }
        // 실행 끝

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
                MessageBox.Show("알람음이 선택되지 않았습니다", "알림");
            } else
            {
                wmp.controls.play();
            }
        }

        private void alram_stop_Click(object sender, EventArgs e)
        {
            if (path == null)
            {
                MessageBox.Show("알람음이 선택되지 않았습니다", "알림");
            } else
            {
                wmp.controls.stop();
            }
        }

        // 알람 설정 클릭시
        private void button_set_Click(object sender, EventArgs e)
        {
            // 알람음 선택 확인
            if (path == null)
            {
                MessageBox.Show("알람음이 선택되지 않았습니다", "알림");
                return;
            }

            // 알람이 이미 설정되어있는경우
            if (set == true)
            {
                if(DialogResult.OK == MessageBox.Show("이미 알람이 설정 되어 있습니다 알람을 재설정 하시겠습니까?", "경고", MessageBoxButtons.OKCancel))
                {
                    // 타이머 초기화하게 멈추기
                    alram_timer.Stop();
                    // 초 초기화
                    second = 0;
                    int setTime = (int)set_time.Value;
                    int setMinute = (int)set_minute.Value;
                    hour = setTime;
                    minute = setMinute;
                    alram_timer.Start();
                    MessageBox.Show(setTime + "시 " + setMinute + "분 이후에 알람이 울립니다.", "알림");
                }
            } else
            {
                int setTime = (int)set_time.Value;
                int setMinute = (int)set_minute.Value;
                hour = setTime;
                minute = setMinute;
                set = true;
                alram_timer.Start();
                MessageBox.Show(setTime + "시 " + setMinute + "분 이후에 알람이 울립니다.", "알림");
            }
        }

        // 초기화 버튼
        private void button_reset_Click(object sender, EventArgs e)
        {
            if (set == true)
            {
                if (DialogResult.OK == MessageBox.Show("현재 알람이 설정 되어 있습니다 정말 초기화 하시겠습니까?", "경고", MessageBoxButtons.OKCancel))
                {
                    // 타이머 멈추기 및 라벨 초기화
                    alram_timer.Stop();
                    label_alram.Text = "알람 설정 되지 않음";
                    label_alram.Location = new System.Drawing.Point(45, 68);
                    set = false;
                    // 초 초기화
                    second = 0;
                    set_time.Value = 0;
                    set_minute.Value = 0;
                }
            } else
            {
                set_time.Value = 0;
                set_minute.Value = 0;
            }
        }
    }
}
