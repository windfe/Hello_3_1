package comt.example.administrator.text3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private String name;
    HashMap<String,String>dictionary;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void lookAll(String str) {//带参数的方法
        if (dictionary==null){
            this.dictionary=new HashMap<>();
        }
        Scanner scan=new Scanner(getResources().openRawResource(R.raw.dortry));
        while (scan.hasNext()){
            String line=scan.nextLine();
            String[] piece=line.split(":");
            if(str.equalsIgnoreCase(piece[0])){//通过形式参数判断是否区分大小写
                this.dictionary.put(piece[0],piece[1]);//hashmap,
                name=piece[0];//通过全局变量传值
            }

        }
    }

    public void lookup(View view) {
        EditText ed=findViewById(R.id.edit);
        String text=ed.getText().toString();
        if (this.dictionary==null){
            lookAll(text);
        }
        String del=this.dictionary.get(name);//***逻辑关系传值
        TextView t=findViewById(R.id.text);
        if (del==null){
             t.setText("your word was not found");
        }
        else
            t.setText(del);

    }

}
