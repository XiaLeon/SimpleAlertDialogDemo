
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.memorydemo.R;

public class AlertDialogDemo extends Activity {

    @Override
    protected void onCreate(Bundle onSavedInstance) {
        super.onCreate(onSavedInstance);
        setContentView(R.layout.alert_dialog_demo);

        Button button = findViewById(R.id.buttonAlertDialog);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(AlertDialogDemo.this)
                        .setTitle("Please choose")

                        // 设置对话框的显示内容，是个内容列表，注意：这里需要传数组类型，比如 R.array 或者 String[]
                        .setItems(R.array.items_alert_dialog, new DialogInterface.OnClickListener() {

                            // 点击列表上的任一项
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String[] items = getResources().getStringArray(R.array.items_alert_dialog);
                                new AlertDialog.Builder(AlertDialogDemo.this)

                                        // 再次弹框，向用户提示 用户刚才选择的内容
                                        .setMessage("You chose: " + items[which])
                                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                            }
                                        }).show();
                            }
                        })

                        // 第一个对话框有个 取消 按钮
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });
    }

}
