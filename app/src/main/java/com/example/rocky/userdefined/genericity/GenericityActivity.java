package com.example.rocky.userdefined.genericity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.example.rocky.userdefined.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class GenericityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_genericity);
        //
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_g_test)
    void btn_g_test(View view) {
        /*
        Point<Integer> point = new Point<>();
        point.setX(10);
        point.setY(20);
        Log.d("sam","x="+point.getX()+" y="+point.getY());
        */
        /*
        InfoImpl<Integer,Double,String> info = new InfoImpl("test");
        //info.setVar("ZXVBBB");
        Log.d("sam","value="+info.getVar());
        try {
            info.parseArray("test",SuccessModel.class);
        }catch (Exception e){
            e.printStackTrace();
        }*/

        //List<? super Manager> list;
        //list = new ArrayList<Manager>();
        // list.add(new Manager());
        //list.add(new Ceo());
        //list = new ArrayList<Manager>();
        // list = new ArrayList<Ceo>();
        //list.add(new Employee());
        //list.add(new Manager());
        //list.add(new Ceo());
        /*
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Mike"));
        list.add(new Employee("Rock"));
        list.add(new Manager("567"));
        list.add(new Ceo("ceo"));
        PersonTrainer personTrainer = new PersonTrainer();
        personTrainer.act(list);


        List<Manager> list1 = new ArrayList<>();

                personTrainer.actSuper(list1);
        for(Manager manager:list1){
            Log.d("sam",manager.getName());
        }
      */
        //反射
        //Class<?> class1 = Manager.class;
        //Log.d("sam",class1.getName());
        /*
        try {
            //Class<?> class1 = Class.forName("com.example.rocky.userdefined.genericity.Manager");
            Class<?> class1 = getClassLoader().loadClass("com.example.rocky.userdefined.genericity.Manager");
            Class<?> parentClass = class1.getSuperclass();
            Class<?>[] interfaces = class1.getInterfaces();
            Log.d("父类", parentClass.getName());
            Log.d("完整类名", class1.getName());
            Log.d("类名", class1.getSimpleName());
            Log.d("包名", class1.getPackage().getName());

            for(Class item:interfaces){
                Log.d("接口",item.getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        */
        Class<?>[] classes = getAllInterface(Ceo.class);
        SpannableStringBuilder builder = new SpannableStringBuilder();
        for(Class clazz:classes){
            builder.append(clazz.getName());
            builder.append(" ");

        }
        Log.d("sam","所有接口："+builder.toString());
    }

    //获取所有接口
    public Class<?>[] getAllInterface(Class<?> clazz){

        Class<?>[] interSelf = clazz.getInterfaces();
        //递归
        Class<?> superClazz = clazz.getSuperclass();
        Class<?>[] interParent = null;
        if(null !=superClazz){
            interParent = getAllInterface(superClazz);
        }
        //返回值
        if( null == interParent && interSelf != null){
            return interSelf;
        }else if( null == interParent && interSelf == null){
            return null;
        }else{
            final int length = interParent.length + interSelf.length;
            Class<?>[] result = new Class[length];
            System.arraycopy(interSelf,0,result,0,interSelf.length);
            System.arraycopy(interParent,0,result,interSelf.length,interParent.length);
            Log.d("sam","result");
            for(Class self:interSelf){
               Log.d("sam","self name="+self.getName());

            }
            for(Class self:interParent){
                Log.d("sam","parent name="+self.getName());

            }
            return result;
        }
    }

    public Class<?>[] getAll(Class<?> clazz){
        Class<?>[] interSelf = clazz.getInterfaces();
        //
        Class<?> superClass = clazz.getSuperclass();
        Class<?>[] interParent = null;

        if(null != superClass){
            interParent = getAll(superClass);
        }

        if(interParent == null && interSelf != null){
            return interSelf;
        }else if(interParent == null && interSelf == null){
            return null;
        }else{
            int length = interParent.length + interSelf.length;
            Class<?>[] result = new Class[length];
            return result;
        }

    }

}
