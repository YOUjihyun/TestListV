package com.jihyun.testlistv;

        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] nameArr = {"Nayeon","Dahyeon","Jeongyeon","Sana",
            "Momo","Chaeyoung","Mina","Jihyo","Zuwi","Nayeon","Dahyeon","Jeongyeon","Sana",
            "Momo","Chaeyoung","Mina","Jihyo","Zuwi"};

    ListView listV;
    ArrayAdapter<String> adapterA;         //어뎁터 만들기

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  //setContentView가 객체를 생성해주고

        this.listV = findViewById(R.id.listV);   // this가 생략됨 자기한테 있는거니깐MainActivity가 갖고있는
        this.adapterA = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,  nameArr);//simple_list_item_1 리스트가나올떄 셀을 만들어주느

        this.listV.setAdapter(this.adapterA);
        // this.adapterA.notifyDataSetChanged();

        this.listV.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {   //i는 몇번째값이냥.

        Intent intentA;
        if (i % 2 == 0) {
            intentA = new Intent(this, SecondActivity.class);
            intentA.putExtra("keyA", nameArr[i]);
            startActivityForResult(intentA, 100);
        } else {
            intentA = new Intent(this, ThirdActivity.class);
            intentA.putExtra("keyA", nameArr[i]);
            startActivityForResult(intentA, 200);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 500){   //버튼 눌러서 되돌아오면 토스트가 뜨고 백버튼 누르면 안뜨고
            Toast.makeText(this,"requestCode: " + requestCode + "resultCode: "+resultCode,
                    Toast.LENGTH_SHORT).show();
        }

    }
}

