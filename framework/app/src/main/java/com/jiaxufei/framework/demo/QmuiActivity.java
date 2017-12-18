package com.jiaxufei.framework.demo;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiaxufei.framework.R;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIKeyboardHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.trello.rxlifecycle2.components.RxActivity;

import static com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON;
import static com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView.REDDOT_POSITION_LEFT;
import static com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView.REDDOT_POSITION_RIGHT;

/**
 * author: 贾旭飞(<a href="mailto:jiaxufei@danlu.com">jiaxufei@danlu.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2017-12-09 下午7:26<br/>
 * <p>
 * <p>
 * 内容描述区域
 * </p>
 */
public class QmuiActivity extends RxActivity {
    private QMUITopBar qmuiTopbar;
    private Button btnDialog;
    private QMUIGroupListView groupListView;
    private QMUICommonListItemView itemView1;
    private QMUICommonListItemView itemView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qmui);
        initView();

    }

    private void initView() {
        qmuiTopbar = (QMUITopBar) findViewById(R.id.qmui_topbar);
        btnDialog = (Button) findViewById(R.id.btn_dialog);
        groupListView = (QMUIGroupListView) findViewById(R.id.groupListView);
        itemView1= (QMUICommonListItemView) findViewById(R.id.itemView1);
        itemView2= (QMUICommonListItemView) findViewById(R.id.itemView2);
        qmuiTopbar.setTitle("功能首页");
        qmuiTopbar.setSubTitle("副标题");
        qmuiTopbar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showMessagePositiveDialog();
                // showMenuDialog();
                showAutoDialog();
            }

        });
        initGroupListView();
    }

    private void initGroupListView() {
        itemView1.setText("姓名");
        itemView1.setDetailText("王二小");
        itemView1.setAccessoryType(ACCESSORY_TYPE_CHEVRON);
        itemView1.setRedDotPosition(REDDOT_POSITION_LEFT);
        itemView1.showRedDot(true);
        itemView2.setText("姓名：张三");


    }

    private void showMessagePositiveDialog() {
        new QMUIDialog.MessageDialogBuilder(this)
                .setTitle("标题")
                .setMessage("确定要发送吗？")
                .addAction(0, "取消", QMUIDialogAction.ACTION_PROP_NEGATIVE, new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                    }
                })
                .addAction("确定", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                        Toast.makeText(QmuiActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    private void showMenuDialog() {
        final String[] items = new String[]{"选项1", "选项2", "选项3"};
        new QMUIDialog.MenuDialogBuilder(this)
                .addItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(QmuiActivity.this, "你选择了 " + items[which], Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).show();
    }

    private void showAutoDialog() {
        QMAutoTestDialogBuilder autoTestDialogBuilder = (QMAutoTestDialogBuilder) new QMAutoTestDialogBuilder(QmuiActivity.this)
                .addAction("取消", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                    }
                })
                .addAction("确定", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        Toast.makeText(QmuiActivity.this, "你点了确定", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
        autoTestDialogBuilder.show();
        QMUIKeyboardHelper.showKeyboard(autoTestDialogBuilder.getEditText(), true);
    }

    class QMAutoTestDialogBuilder extends QMUIDialog.AutoResizeDialogBuilder {
        private Context mContext;
        private EditText mEditText;

        public QMAutoTestDialogBuilder(Context context) {
            super(context);
            mContext = context;
        }


        public EditText getEditText() {
            return mEditText;
        }

        @Override
        public View onBuildContent(QMUIDialog dialog, ScrollView parent) {
            LinearLayout layout = new LinearLayout(mContext);
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.setLayoutParams(new ScrollView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            int padding = QMUIDisplayHelper.dp2px(mContext, 20);
            layout.setPadding(padding, padding, padding, padding);
            mEditText = new EditText(mContext);
            QMUIViewHelper.setBackgroundKeepingPadding(mEditText, QMUIResHelper.getAttrDrawable(mContext, R.attr.qmui_list_item_bg_with_border_bottom));
            mEditText.setHint("输入框");
            LinearLayout.LayoutParams editTextLP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, QMUIDisplayHelper.dpToPx(50));
            editTextLP.bottomMargin = QMUIDisplayHelper.dp2px(QmuiActivity.this, 15);
            mEditText.setLayoutParams(editTextLP);
            layout.addView(mEditText);
            TextView textView = new TextView(mContext);
            textView.setLineSpacing(QMUIDisplayHelper.dp2px(QmuiActivity.this, 4), 1.0f);
            textView.setText("观察聚焦输入框后，键盘升起降下时 dialog 的高度自适应变化。\n\n" +
                    "QMUI Android 的设计目的是用于辅助快速搭建一个具备基本设计还原效果的 Android 项目，" +
                    "同时利用自身提供的丰富控件及兼容处理，让开发者能专注于业务需求而无需耗费精力在基础代码的设计上。" +
                    "不管是新项目的创建，或是已有项目的维护，均可使开发效率和项目质量得到大幅度提升。");
            textView.setTextColor(ContextCompat.getColor(QmuiActivity.this, R.color.qmui_config_color_blue));
            textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            layout.addView(textView);
            return layout;
        }
    }
}
