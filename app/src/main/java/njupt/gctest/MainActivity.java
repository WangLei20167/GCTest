package njupt.gctest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import nc.NCUtils;
import utils.Test;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onTest(View view) {

        byte[][] bytes = new byte[8][2621445];
        //System.gc();
        Test.test(bytes);

        NCUtils.InitGalois();
        byte[] a = {34, 112, 12, 67};
        byte[] b = {22, 17, 100, 4};
        byte[] c = NCUtils.Multiply(a, 2, 2, b, 2, 2);

        byte[] invA = NCUtils.InverseMatrix(a, 2);
        byte[] e = {34, 21, 78, -13, 45, 8};
        int rank = NCUtils.getRank(e, 2, 3);
        byte[] f = {89, 12, -1, 54, 11, 21, -22, 13};
        int rank1 = NCUtils.getRank(f, 2, 4);

        //测试矩阵不满秩时   求逆会返回什么
        byte[] g = {12, 32, 14, 87, 2, 123, 87, 2, 123};
        byte[] invG = NCUtils.InverseMatrix(g, 3);

        int rank2 = NCUtils.getRank(g, 3, 3);
        NCUtils.UninitGalois();
    }
}
