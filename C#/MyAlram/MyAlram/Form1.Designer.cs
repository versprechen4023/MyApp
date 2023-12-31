﻿using System;

namespace MyAlram
{
    partial class Form1
    {
        /// <summary>
        /// 필수 디자이너 변수입니다.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 사용 중인 모든 리소스를 정리합니다.
        /// </summary>
        /// <param name="disposing">관리되는 리소스를 삭제해야 하면 true이고, 그렇지 않으면 false입니다.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form 디자이너에서 생성한 코드

        /// <summary>
        /// 디자이너 지원에 필요한 메서드입니다. 
        /// 이 메서드의 내용을 코드 편집기로 수정하지 마세요.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.label_time = new System.Windows.Forms.Label();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.button_reset = new System.Windows.Forms.Button();
            this.button_set = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.set_minute = new System.Windows.Forms.NumericUpDown();
            this.set_time = new System.Windows.Forms.NumericUpDown();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.alram_stop = new System.Windows.Forms.Button();
            this.alram_play = new System.Windows.Forms.Button();
            this.alram_name = new System.Windows.Forms.RichTextBox();
            this.button_load = new System.Windows.Forms.Button();
            this.groupBox4 = new System.Windows.Forms.GroupBox();
            this.label_alram = new System.Windows.Forms.Label();
            this.groupBox5 = new System.Windows.Forms.GroupBox();
            this.button_note = new System.Windows.Forms.Button();
            this.button_panel = new System.Windows.Forms.Button();
            this.button_cmd = new System.Windows.Forms.Button();
            this.alram_file = new System.Windows.Forms.OpenFileDialog();
            this.alram_timer = new System.Windows.Forms.Timer(this.components);
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.set_minute)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.set_time)).BeginInit();
            this.groupBox3.SuspendLayout();
            this.groupBox4.SuspendLayout();
            this.groupBox5.SuspendLayout();
            this.SuspendLayout();
            // 
            // timer1
            // 
            this.timer1.Enabled = true;
            this.timer1.Interval = 1000;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // label_time
            // 
            this.label_time.AutoSize = true;
            this.label_time.Font = new System.Drawing.Font("굴림", 12F);
            this.label_time.Location = new System.Drawing.Point(6, 28);
            this.label_time.Name = "label_time";
            this.label_time.Size = new System.Drawing.Size(173, 16);
            this.label_time.TabIndex = 5;
            this.label_time.Text = "현재시각 : 오후 2:18:15";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.label_time);
            this.groupBox1.Font = new System.Drawing.Font("굴림", 14F, System.Drawing.FontStyle.Bold);
            this.groupBox1.Location = new System.Drawing.Point(343, 12);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(236, 100);
            this.groupBox1.TabIndex = 8;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "시각";
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.button_reset);
            this.groupBox2.Controls.Add(this.button_set);
            this.groupBox2.Controls.Add(this.label2);
            this.groupBox2.Controls.Add(this.label1);
            this.groupBox2.Controls.Add(this.set_minute);
            this.groupBox2.Controls.Add(this.set_time);
            this.groupBox2.Font = new System.Drawing.Font("굴림", 14F, System.Drawing.FontStyle.Bold);
            this.groupBox2.Location = new System.Drawing.Point(12, 12);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(325, 100);
            this.groupBox2.TabIndex = 9;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "타이머 설정";
            // 
            // button_reset
            // 
            this.button_reset.Font = new System.Drawing.Font("굴림", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.button_reset.Location = new System.Drawing.Point(127, 65);
            this.button_reset.Name = "button_reset";
            this.button_reset.Size = new System.Drawing.Size(93, 29);
            this.button_reset.TabIndex = 5;
            this.button_reset.Text = "초기화";
            this.button_reset.UseVisualStyleBackColor = true;
            this.button_reset.Click += new System.EventHandler(this.button_reset_Click);
            // 
            // button_set
            // 
            this.button_set.Font = new System.Drawing.Font("굴림", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.button_set.Location = new System.Drawing.Point(25, 65);
            this.button_set.Name = "button_set";
            this.button_set.Size = new System.Drawing.Size(93, 29);
            this.button_set.TabIndex = 4;
            this.button_set.Text = "알람 설정";
            this.button_set.UseVisualStyleBackColor = true;
            this.button_set.Click += new System.EventHandler(this.button_set_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("굴림", 12F);
            this.label2.Location = new System.Drawing.Point(258, 28);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(23, 16);
            this.label2.TabIndex = 3;
            this.label2.Text = "분";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("굴림", 12F);
            this.label1.Location = new System.Drawing.Point(124, 28);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(23, 16);
            this.label1.TabIndex = 2;
            this.label1.Text = "시";
            // 
            // set_minute
            // 
            this.set_minute.Font = new System.Drawing.Font("굴림", 12F);
            this.set_minute.Location = new System.Drawing.Point(156, 24);
            this.set_minute.Name = "set_minute";
            this.set_minute.Size = new System.Drawing.Size(96, 26);
            this.set_minute.TabIndex = 1;
            // 
            // set_time
            // 
            this.set_time.Font = new System.Drawing.Font("굴림", 12F);
            this.set_time.Location = new System.Drawing.Point(25, 24);
            this.set_time.Name = "set_time";
            this.set_time.Size = new System.Drawing.Size(96, 26);
            this.set_time.TabIndex = 0;
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.alram_stop);
            this.groupBox3.Controls.Add(this.alram_play);
            this.groupBox3.Controls.Add(this.alram_name);
            this.groupBox3.Controls.Add(this.button_load);
            this.groupBox3.Font = new System.Drawing.Font("굴림", 14F, System.Drawing.FontStyle.Bold);
            this.groupBox3.Location = new System.Drawing.Point(12, 118);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(325, 157);
            this.groupBox3.TabIndex = 10;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "알람음 설정";
            // 
            // alram_stop
            // 
            this.alram_stop.Font = new System.Drawing.Font("굴림", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.alram_stop.Location = new System.Drawing.Point(219, 122);
            this.alram_stop.Name = "alram_stop";
            this.alram_stop.Size = new System.Drawing.Size(100, 29);
            this.alram_stop.TabIndex = 4;
            this.alram_stop.Text = "알람음정지";
            this.alram_stop.UseVisualStyleBackColor = true;
            this.alram_stop.Click += new System.EventHandler(this.alram_stop_Click);
            // 
            // alram_play
            // 
            this.alram_play.Font = new System.Drawing.Font("굴림", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.alram_play.Location = new System.Drawing.Point(115, 122);
            this.alram_play.Name = "alram_play";
            this.alram_play.Size = new System.Drawing.Size(97, 29);
            this.alram_play.TabIndex = 3;
            this.alram_play.Text = "알람음재생";
            this.alram_play.UseVisualStyleBackColor = true;
            this.alram_play.Click += new System.EventHandler(this.alram_play_Click);
            // 
            // alram_name
            // 
            this.alram_name.BackColor = System.Drawing.SystemColors.ActiveBorder;
            this.alram_name.Location = new System.Drawing.Point(6, 20);
            this.alram_name.Name = "alram_name";
            this.alram_name.ReadOnly = true;
            this.alram_name.Size = new System.Drawing.Size(313, 96);
            this.alram_name.TabIndex = 2;
            this.alram_name.Text = "";
            // 
            // button_load
            // 
            this.button_load.Font = new System.Drawing.Font("굴림", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.button_load.Location = new System.Drawing.Point(6, 122);
            this.button_load.Name = "button_load";
            this.button_load.Size = new System.Drawing.Size(103, 29);
            this.button_load.TabIndex = 1;
            this.button_load.Text = "알람음등록";
            this.button_load.UseVisualStyleBackColor = true;
            this.button_load.Click += new System.EventHandler(this.button_load_Click);
            // 
            // groupBox4
            // 
            this.groupBox4.Controls.Add(this.label_alram);
            this.groupBox4.Font = new System.Drawing.Font("굴림", 14F, System.Drawing.FontStyle.Bold);
            this.groupBox4.Location = new System.Drawing.Point(343, 118);
            this.groupBox4.Name = "groupBox4";
            this.groupBox4.Size = new System.Drawing.Size(236, 157);
            this.groupBox4.TabIndex = 11;
            this.groupBox4.TabStop = false;
            this.groupBox4.Text = "알람 시간";
            // 
            // label_alram
            // 
            this.label_alram.AutoSize = true;
            this.label_alram.Font = new System.Drawing.Font("굴림", 12F);
            this.label_alram.Location = new System.Drawing.Point(45, 68);
            this.label_alram.Name = "label_alram";
            this.label_alram.Size = new System.Drawing.Size(150, 16);
            this.label_alram.TabIndex = 6;
            this.label_alram.Text = "알람 설정 되지 않음";
            // 
            // groupBox5
            // 
            this.groupBox5.Controls.Add(this.button_note);
            this.groupBox5.Controls.Add(this.button_panel);
            this.groupBox5.Controls.Add(this.button_cmd);
            this.groupBox5.Font = new System.Drawing.Font("굴림", 14F, System.Drawing.FontStyle.Bold);
            this.groupBox5.Location = new System.Drawing.Point(12, 281);
            this.groupBox5.Name = "groupBox5";
            this.groupBox5.Size = new System.Drawing.Size(567, 63);
            this.groupBox5.TabIndex = 12;
            this.groupBox5.TabStop = false;
            this.groupBox5.Text = "프로그램 실행";
            // 
            // button_note
            // 
            this.button_note.Font = new System.Drawing.Font("굴림", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.button_note.Location = new System.Drawing.Point(182, 28);
            this.button_note.Name = "button_note";
            this.button_note.Size = new System.Drawing.Size(82, 29);
            this.button_note.TabIndex = 2;
            this.button_note.Text = "메모장";
            this.button_note.UseVisualStyleBackColor = true;
            this.button_note.Click += new System.EventHandler(this.button_note_Click);
            // 
            // button_panel
            // 
            this.button_panel.Font = new System.Drawing.Font("굴림", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.button_panel.Location = new System.Drawing.Point(94, 28);
            this.button_panel.Name = "button_panel";
            this.button_panel.Size = new System.Drawing.Size(82, 29);
            this.button_panel.TabIndex = 1;
            this.button_panel.Text = "제어판";
            this.button_panel.UseVisualStyleBackColor = true;
            this.button_panel.Click += new System.EventHandler(this.button_panel_Click);
            // 
            // button_cmd
            // 
            this.button_cmd.Font = new System.Drawing.Font("굴림", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.button_cmd.Location = new System.Drawing.Point(6, 28);
            this.button_cmd.Name = "button_cmd";
            this.button_cmd.Size = new System.Drawing.Size(82, 29);
            this.button_cmd.TabIndex = 0;
            this.button_cmd.Text = "CMD";
            this.button_cmd.UseVisualStyleBackColor = true;
            this.button_cmd.Click += new System.EventHandler(this.button_cmd_Click);
            // 
            // alram_file
            // 
            this.alram_file.Filter = "윈도우미디어파일(*.wav)|*wav|mp3파일(*.mp3)|*.mp3";
            // 
            // alram_timer
            // 
            this.alram_timer.Interval = 1000;
            this.alram_timer.Tick += new System.EventHandler(this.alram_timer_Tick);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(591, 356);
            this.Controls.Add(this.groupBox5);
            this.Controls.Add(this.groupBox4);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.MaximizeBox = false;
            this.Name = "Form1";
            this.Text = "알람";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.set_minute)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.set_time)).EndInit();
            this.groupBox3.ResumeLayout(false);
            this.groupBox4.ResumeLayout(false);
            this.groupBox4.PerformLayout();
            this.groupBox5.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.Label label_time;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.GroupBox groupBox4;
        private System.Windows.Forms.Label label_alram;
        private System.Windows.Forms.GroupBox groupBox5;
        private System.Windows.Forms.NumericUpDown set_minute;
        private System.Windows.Forms.NumericUpDown set_time;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button button_cmd;
        private System.Windows.Forms.Button button_note;
        private System.Windows.Forms.Button button_panel;
        private System.Windows.Forms.Button button_reset;
        private System.Windows.Forms.Button button_set;
        private System.Windows.Forms.Button button_load;
        private System.Windows.Forms.OpenFileDialog alram_file;
        private System.Windows.Forms.RichTextBox alram_name;
        private System.Windows.Forms.Button alram_stop;
        private System.Windows.Forms.Button alram_play;
        private System.Windows.Forms.Timer alram_timer;
    }
}

