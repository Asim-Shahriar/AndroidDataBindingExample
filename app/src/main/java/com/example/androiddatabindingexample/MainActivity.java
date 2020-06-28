package com.example.androiddatabindingexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.androiddatabindingexample.databinding.ActivityMainBinding;
import com.example.androiddatabindingexample.models.Product;
import com.example.androiddatabindingexample.util.Products;

public class MainActivity extends AppCompatActivity implements IMainActivity{

    ActivityMainBinding mBinding;
    private Product mProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        Products products=new Products();
        mProduct=products.PRODUCTS[0];
        mBinding.setProduct(mProduct);

        mBinding.setQuantity(1);
        mBinding.setIMainActivity((IMainActivity)this);
    }

    @Override
    public void inflateQuantityDialog() {

     ChooseQuantityDialog dialog=new ChooseQuantityDialog();
     dialog.show(getSupportFragmentManager(),getString(R.string.dialog_choose_quantity));
    }

    @Override
    public void setQuantity(int quantity) {
        mBinding.setQuantity(quantity);
    }
}