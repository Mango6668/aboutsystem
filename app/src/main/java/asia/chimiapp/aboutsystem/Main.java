package asia.chimiapp.aboutsystem;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {
    private Button bt1;
    private TextView tv1;
    private static final String KEY = "o_F_RtwyzSMC2yKYDUyhsp_95jLCN0_R";
    private static final String COPYRIGHT = "本系统由☯赤米☯提供\n" +
            "\t\tQQ群：865726433\n" +
            "\t\tQQ：2934301923\n" +
            "\t\t免费提供，倒卖狗我囸你仙人！";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chimiapp);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("关于这个系统")
                //.setIcon(R.drawable.ic_launcher)
                .setMessage(COPYRIGHT)
                .setPositiveButton("加入QQ群", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dia, int which) {
                        joinQQGroup(KEY);

                    }
                })
                .setNegativeButton("知道啦！", null)
                .create();
        dialog.show();

        Init();


    }

    private void  Init(){
        bt1 = findViewById(R.id.bt1);
        tv1 = findViewById(R.id.tv1);
        tv1.setText(COPYRIGHT);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean b = joinQQGroup(KEY);
                if (b == true){
                    Toast.makeText(getApplicationContext(),"跳转成功！~", Toast.LENGTH_LONG).show();
                    return;
                }

                Toast.makeText(getApplicationContext(),"跳转失败！~\n您好像没有安装QQ！~", Toast.LENGTH_LONG).show();

            }
        });

    }

    /**
     * 本方法用于发起手Q加群流程<br>
     * @param key QQ群的KEY
     * @return 跳转的结果 布尔值 跳转成功返回ture，反则亦然
     */

    private boolean joinQQGroup(String key) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26jump_from%3Dwebapi%26k%3D" + key));
        // 此Flag可根据具体产品需要自定义，如设置，则在加群界面按返回，返回手Q主界面，不设置，按返回会返回到呼起产品界面    //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        try {
            startActivity(intent);
            return true;
        } catch (Exception e) {
            // 未安装手Q或安装的版本不支持
            return false;
        }
    }

}