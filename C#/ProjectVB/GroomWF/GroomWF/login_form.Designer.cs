namespace GroomWF
{
    partial class login_form
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
            this.id_label = new System.Windows.Forms.Label();
            this.pass_label = new System.Windows.Forms.Label();
            this.Id_text = new System.Windows.Forms.TextBox();
            this.pass_text = new System.Windows.Forms.TextBox();
            this.login_button = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // id_label
            // 
            this.id_label.AutoSize = true;
            this.id_label.Location = new System.Drawing.Point(38, 32);
            this.id_label.Name = "id_label";
            this.id_label.Size = new System.Drawing.Size(41, 12);
            this.id_label.TabIndex = 0;
            this.id_label.Text = "로그인";
            // 
            // pass_label
            // 
            this.pass_label.AutoSize = true;
            this.pass_label.Location = new System.Drawing.Point(38, 74);
            this.pass_label.Name = "pass_label";
            this.pass_label.Size = new System.Drawing.Size(53, 12);
            this.pass_label.TabIndex = 1;
            this.pass_label.Text = "비밀번호";
            // 
            // Id_text
            // 
            this.Id_text.Location = new System.Drawing.Point(130, 29);
            this.Id_text.Name = "Id_text";
            this.Id_text.Size = new System.Drawing.Size(113, 21);
            this.Id_text.TabIndex = 2;
            // 
            // pass_text
            // 
            this.pass_text.Location = new System.Drawing.Point(130, 71);
            this.pass_text.Name = "pass_text";
            this.pass_text.PasswordChar = '*';
            this.pass_text.Size = new System.Drawing.Size(113, 21);
            this.pass_text.TabIndex = 3;
            // 
            // login_button
            // 
            this.login_button.Location = new System.Drawing.Point(278, 46);
            this.login_button.Name = "login_button";
            this.login_button.Size = new System.Drawing.Size(61, 30);
            this.login_button.TabIndex = 4;
            this.login_button.Text = "로그인";
            this.login_button.UseVisualStyleBackColor = true;
            this.login_button.Click += new System.EventHandler(this.login_button_Click);
            // 
            // login_form
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(383, 134);
            this.Controls.Add(this.login_button);
            this.Controls.Add(this.pass_text);
            this.Controls.Add(this.Id_text);
            this.Controls.Add(this.pass_label);
            this.Controls.Add(this.id_label);
            this.KeyPreview = true;
            this.MaximizeBox = false;
            this.Name = "login_form";
            this.Text = "Groom Management";
            this.Load += new System.EventHandler(this.login_form_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label id_label;
        private System.Windows.Forms.Label pass_label;
        private System.Windows.Forms.TextBox Id_text;
        private System.Windows.Forms.TextBox pass_text;
        private System.Windows.Forms.Button login_button;
    }
}

