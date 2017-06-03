package com.example.bazinga.OrderMeal14110100109.hepler;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bazinga.OrderMeal14110100109.R;

/**
 * Created by bazinga on 2017/5/30.
 */

public class DialogHelper {

    public static DialogHelper dialogHelper;
    private String dialogContent = "";
    private Activity activity = null;

    private View view_custom;
    private AlertDialog alert = null;
    private AlertDialog.Builder builder = null;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    private DialogHelper(){}

    public static DialogHelper getDialogHelper(){
        if (dialogHelper == null)
            return new DialogHelper();
        else{
            return dialogHelper;
        }

    }

    public String getDialogContent() {
        return dialogContent;
    }

    public void setDialogContent(String dialogContent) {
        this.dialogContent = dialogContent;
    }

    public void displayDialog(){
        builder = new AlertDialog.Builder(activity);
        final LayoutInflater inflater = activity.getLayoutInflater();
        view_custom = inflater.inflate(R.layout.dialog_hint, null,false);
        TextView textView = (TextView) view_custom.findViewById(R.id.progressHint);

        if (textView != null)
            textView.setText(dialogContent);

        builder.setView(view_custom);
        builder.setCancelable(false);
        alert = builder.create();

        alert.show();
    }

    public void closeDialog(){
        if (alert != null){
            alert.cancel();
        }
    }

    public void displayBuyDialog(){
        builder=new AlertDialog.Builder(activity);
        builder.setTitle(R.string.BUY_HINT);
        builder.setMessage(R.string.BUY_HINT_CONTNET);

        //监听下方button点击事件
        builder.setPositiveButton(R.string.YES, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNegativeButton(R.string.NO, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.setCancelable(true);
        alert = builder.create();
        alert.show();
    }
}
