package com.yl.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yl.greendaodemo.db.Info;
import com.yl.greendaodemo.db.InfoDao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.dao.query.QueryBuilder;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.btn_delete)
    Button btnDelete;
    @BindView(R.id.btn_update)
    Button btnUpdate;
    @BindView(R.id.btn_query)
    Button btnQuery;
    private InfoDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MyApp application = (MyApp) getApplication();
        dao = application.getDao();
    }

    @OnClick({R.id.btn_add, R.id.btn_delete, R.id.btn_update, R.id.btn_query})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add://增
                Info user = new Info(null, "zhangsan", 12, "13112345678");
                Info user2 = new Info(null, "lisi", 22, "13222345678");
                Info user3 = new Info(null, "wangwu", 32, "13332345678");
                Info user4 = new Info(null, "zhaoqi", 42, "13442345678");
                dao.insert(user);
                dao.insert(user2);
                dao.insert(user3);
                dao.insert(user4);
                break;
            case R.id.btn_delete://删
                dao.deleteByKey(1L);
                break;
            case R.id.btn_update://改
                user4 = new Info(null, "赵四", 42, "13442345678");
                dao.update(user4);

                break;
            case R.id.btn_query://查
                QueryBuilder<Info> infoQueryBuilder = dao.queryBuilder();
                QueryBuilder<Info> builder = infoQueryBuilder.where(InfoDao.Properties.Age.eq("32"));
                List<Info> list = builder.list();
                for (Info info:
                     list) {
                    Log.e(TAG, "onClick: "+info.getName()+"--"+info.getAge()+"--"+info.getTel() );

                }
                break;
        }
    }
}
