package com.example.bazinga.OrderMeal14110100109.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.adapter.FoodAdapter;
import com.example.bazinga.OrderMeal14110100109.bean.ShopFood;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IndexFragment extends Fragment
{
	@BindView(R.id.recyclerView)

	RecyclerView recyclerView;

	FoodAdapter foodAdapter ;

	private List<ShopFood> datas = new ArrayList<>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{

		View view = inflater.inflate(R.layout.tab01, container, false);

		ButterKnife.bind(this,view);

		getData();

		initRecyclerView();

		showData();

		return view;
	}


	private void initRecyclerView() {
		LinearLayoutManager ll = new LinearLayoutManager(getContext());
		ll.setOrientation(LinearLayoutManager.VERTICAL);
		recyclerView.setLayoutManager(ll);

	}

	private void getData() {

		for (int i=0;i<20;i++) {

			ShopFood food1 = new ShopFood();
		//	food1.setArea("东软"+i+"期");
		//	food1.setFoodRank(1.2f+i%5);
		//	food1.setImage(" ");
		//	food1.setTitle("食物"+i);
			datas.add(food1);

		}
	}

	private void getData1() {

//	getData1	Retrofit retrofit = new Retrofit.Builder()
//				.baseUrl("http://www.tngou.net/")
//				.addConverterFactory(GsonConverterFactory.create())
//				.build();
//
//		final Apiservice infoApi = retrofit.create(Apiservice.class);
//
//		Call<Cook> call =  infoApi.getCookList();
//
//		call.enqueue(new Callback<Cook>() {
//			@Override
//			public void onResponse(Call<Cook> call, Response<Cook> response) {
//				if(response.isSuccessful()){
//
//					Cook infoBean = response.body();
//
//					List<Cook.TngouBean> lists = infoBean.getTngou();

					//foodAdapter = new FoodAdapter(lists,getContext());

				//	recyclerView.setAdapter(foodAdapter);

//					System.out.println("---请求成功");
//					List<Info.ResultsBean> result = infoBean.getResults();
//					myadapter = new RV_DiscoverAdapter(getActivity() , result, DiscoverFragment.this);
//					recyclerView.setAdapter(myadapter);
//					//初始化点击事件
//					initOnclick();
//				}
//			}
//
//			@Override
//			public void onFailure(Call<Cook> call, Throwable t) {
//				t.printStackTrace();
//			}
//		});

	}


	public void getData2(){

		String data = "{\"tngou\": [\n" +
				"    {\n" +
				"        \"count\": 40,\n" +
				"        \"description\": \"芒果切丁，放入料理机，与西瓜冰一起打匀，加入少许酸奶调味，撒入芒果粒点缀即可\",\n" +
				"        \"fcount\": 0,\n" +
				"        \"food\": \"小西瓜,芒果,酸奶\",\n" +
				"        \"id\": 78104,\n" +
				"        \"images\": \"\",\n" +
				"        \"img\": \"/cook/080319/1dc8ef1bb994d840b0dbe1de4f419259.jpg\",\n" +
				"        \"keywords\": \"放入 西瓜 芒果 料理 少许 \",\n" +
				"        \"name\": \"西瓜芒果冰沙\",\n" +
				"        \"rcount\": 0\n" +
				"    },\n" +
				"    {\n" +
				"        \"count\": 40,\n" +
				"        \"description\": \"将蘑菇、素火腿切成丝状，以橄榄油爆香后，再加入糙米饭和青酱拌炒约5分钟，再加入调味料拌匀后，起锅前再洒上松子即可\",\n" +
				"        \"fcount\": 0,\n" +
				"        \"food\": \"罗勒叶,松子,橄榄油,糙米,饭,蘑菇,素火腿,黑胡椒粉,高汤\",\n" +
				"        \"id\": 24978,\n" +
				"        \"images\": \"\",\n" +
				"        \"img\": \"/cook/080301/32bf7e7faa533682e0ac5bf5dead5d83.jpg\",\n" +
				"        \"keywords\": \"糙米饭 橄榄油 加入 罗勒 松子 \",\n" +
				"        \"name\": \"素火腿青酱松仁炒饭\",\n" +
				"        \"rcount\": 0\n" +
				"    },\n" +
				"    {\n" +
				"        \"count\": 40,\n" +
				"        \"description\": \"材料豆渣150公克，玉米粒20公克，韭菜末10公克，猪绞肉80公克，鸡蛋1个，面粉2大汤匙，太白粉2大汤匙，酱油1大汤匙，柴鱼粉1/2茶匙，香油1茶匙，胡椒粉少许做法1\",\n" +
				"        \"fcount\": 0,\n" +
				"        \"food\": \"豆渣,玉米粒,韭菜,猪绞肉,鸡蛋,面粉,太白粉,酱油,柴鱼粉,香油,胡椒粉\",\n" +
				"        \"id\": 24990,\n" +
				"        \"images\": \"\",\n" +
				"        \"img\": \"/cook/080301/e968fc2a93ab1d31c767589ba2b83708.jpg\",\n" +
				"        \"keywords\": \"汤匙 豆渣饼 茶匙 金黄色 玉米粒 \",\n" +
				"        \"name\": \"翡翠豆渣煎饼\",\n" +
				"        \"rcount\": 0\n" +
				"    },\n" +
				"    {\n" +
				"        \"count\": 40,\n" +
				"        \"description\": \"将奶油置于室温下软化，再加入砂糖搅拌至光滑状，另将全蛋分成两次加入，并同时拌匀\",\n" +
				"        \"fcount\": 0,\n" +
				"        \"food\": \"奶油,蛋,低筋面粉,黄豆粉,杏仁碎,苏打粉\",\n" +
				"        \"id\": 24991,\n" +
				"        \"images\": \"\",\n" +
				"        \"img\": \"/cook/080301/d6b24ad12dcf0deba469ba7381e4c051.jpg\",\n" +
				"        \"keywords\": \"加入 苏打粉 作法 烤箱 奶油 \",\n" +
				"        \"name\": \"手工豆香饼干\",\n" +
				"        \"rcount\": 0\n" +
				"    },\n" +
				"    {\n" +
				"        \"count\": 40,\n" +
				"        \"description\": \"奶茶粉放入杯中，一边加入开水，一边用筷子搅拌2\",\n" +
				"        \"fcount\": 0,\n" +
				"        \"food\": \"炒米,奶茶,粉\",\n" +
				"        \"id\": 78249,\n" +
				"        \"images\": \"\",\n" +
				"        \"img\": \"/cook/080319/6effd4d6a41c169eee9560e33f58bc29.jpg\",\n" +
				"        \"keywords\": \"奶茶 左右 放入 搅拌 炒米 \",\n" +
				"        \"name\": \"奶茶蒙古米\",\n" +
				"        \"rcount\": 0\n" +
				"    },\n" +
				"    {\n" +
				"        \"count\": 40,\n" +
				"        \"description\": \"锅烧热，刷一层油，油烧热后，将洗净沥干水份的小刁子平铺在锅中3\",\n" +
				"        \"fcount\": 0,\n" +
				"        \"food\": \"刁子鱼,小红辣椒,生抽,陈醋\",\n" +
				"        \"id\": 78250,\n" +
				"        \"images\": \"\",\n" +
				"        \"img\": \"/cook/080319/b0f75e41b26ecb7616cd8cd020cb353b.jpg\",\n" +
				"        \"keywords\": \"金黄 材料 加入 陈醋 辣椒 \",\n" +
				"        \"name\": \"香酥小刁子\",\n" +
				"        \"rcount\": 0\n" +
				"    },\n" +
				"    {\n" +
				"        \"count\": 40,\n" +
				"        \"description\": \"材料洋葱碎50公克，蒜头末15公克，姜末10公克，芥末酱2茶匙，洋香菜碎1大匙，番茄酱4大匙，柳橙汁120cc，砂糖100公克，盐1茶匙，黑胡椒少许，梅林辣酱油1匙，花生酱100公克，奶油30公克做法1\",\n" +
				"        \"fcount\": 0,\n" +
				"        \"food\": \"洋葱碎,蒜头,芥末酱,洋香菜,番茄酱,柳橙汁,黑胡椒,梅林辣酱油,花生酱,奶油\",\n" +
				"        \"id\": 25006,\n" +
				"        \"images\": \"\",\n" +
				"        \"img\": \"/cook/080301/db5a149a739161da75530355fd67282d.jpg\",\n" +
				"        \"keywords\": \"材料 奶油 大匙 茶匙 黑胡椒 \",\n" +
				"        \"name\": \"花生烤肉酱\",\n" +
				"        \"rcount\": 0\n" +
				"    },\n" +
				"    {\n" +
				"        \"count\": 40,\n" +
				"        \"description\": \"菜谱简介数量：12个材料中筋面粉200公克，杂粮粉100公克，泡打粉5公克，小苏打粉1公克，植物性奶油80公克，奶水220cc，黑糖60公克，枫糖30公克，燕麦片30公克，核桃适量，南瓜子适量，黑芝麻粒适量，白芝麻粒适量做法1\",\n" +
				"        \"fcount\": 0,\n" +
				"        \"food\": \"中筋面粉,杂粮粉,泡打粉,小苏打粉,植物性奶油,奶水,黑糖,枫糖,燕麦片,核桃,南瓜子,黑芝麻,白芝麻\",\n" +
				"        \"id\": 25010,\n" +
				"        \"images\": \"\",\n" +
				"        \"img\": \"/cook/080301/10dcf4608870d1d2c7f87dc0ec127930.jpg\",\n" +
				"        \"keywords\": \"加入 适量 作法 拌匀 燕麦片 \",\n" +
				"        \"name\": \"杂粮蛋糕\",\n" +
				"        \"rcount\": 0\n" +
				"    },\n" +
				"    {\n" +
				"        \"count\": 40,\n" +
				"        \"description\": \"材料鳕鱼150g，红辣椒1个，小红尖椒2个，蒜3瓣，姜1小块，辣椒酱1大勺，盐少许，鸡精适量做法1\",\n" +
				"        \"fcount\": 0,\n" +
				"        \"food\": \"鳕鱼,红辣椒,红尖椒,辣椒酱,鸡精\",\n" +
				"        \"id\": 78265,\n" +
				"        \"images\": \"\",\n" +
				"        \"img\": \"/cook/080319/d7860416c56ec2bc72364eeee7700167.jpg\",\n" +
				"        \"keywords\": \"放入 红辣椒 辣椒酱 洗净 姜蒜 \",\n" +
				"        \"name\": \"香辣鳕鱼块\",\n" +
				"        \"rcount\": 0\n" +
				"    },\n" +
				"    {\n" +
				"        \"count\": 40,\n" +
				"        \"description\": \"菜谱简介数量：15个材料低筋面粉120公克，泡打粉3公克，植物性奶油150公克，奶水30cc，黑糖60公克，燕麦片90公克，椰子粉80公克，葡萄干30公克做法1\",\n" +
				"        \"fcount\": 0,\n" +
				"        \"food\": \"低筋面粉,泡打粉,植物性奶油,奶水,黑糖,燕麦片,椰子粉,葡萄干\",\n" +
				"        \"id\": 25013,\n" +
				"        \"images\": \"\",\n" +
				"        \"img\": \"/cook/080301/a4c7a6025541d0445035d6474eacbb8a.jpg\",\n" +
				"        \"keywords\": \"作法 燕麦片 葡萄干 加入 泡打粉 \",\n" +
				"        \"name\": \"燕麦葡萄饼\",\n" +
				"        \"rcount\": 0\n" +
				"    },\n" +
				"    {\n" +
				"        \"count\": 40,\n" +
				"        \"description\": \"将塔模刷上一层薄薄的奶油（份量外），取作法1的塔皮，用手沿着塔模轻捏成薄片，使面皮贴着模型，多余的用切面刀切除，用牙签在面皮上面戳孔\",\n" +
				"        \"fcount\": 0,\n" +
				"        \"food\": \"奶油乳酪,植物性奶油,发粉,小苏打粉,桂圆,葡萄干,二砂糖,核桃\",\n" +
				"        \"id\": 25017,\n" +
				"        \"images\": \"\",\n" +
				"        \"img\": \"/cook/080301/dc0453279fbe8e3195e0fa4a4026d69b.jpg\",\n" +
				"        \"keywords\": \"奶油 作法 加入 植物性 馅料 \",\n" +
				"        \"name\": \"桂圆塔\",\n" +
				"        \"rcount\": 0\n" +
				"    },\n" +
				"    {\n" +
				"        \"count\": 40,\n" +
				"        \"description\": \"日式松饼面煳倒入模型中烤约3分钟，至起泡即可盖上盖子，停留约10秒，即可取出\",\n" +
				"        \"fcount\": 0,\n" +
				"        \"food\": \"蛋,蜂蜜,牛奶,低筋面粉,泡打粉,玉米粉,奶油,红豆\",\n" +
				"        \"id\": 25018,\n" +
				"        \"images\": \"\",\n" +
				"        \"img\": \"/cook/080301/a1b0797f6bf948c1fb885bf4007988f1.jpg\",\n" +
				"        \"keywords\": \"加入 泡打粉 细砂糖 玉米粉 奶油 \",\n" +
				"        \"name\": \"红豆松饼捲\",\n" +
				"        \"rcount\": 0\n" +
				"    },\n" +
				"    {\n" +
				"        \"count\": 40,\n" +
				"        \"description\": \"取一汤锅，先放入高汤煮至滚沸，再放入黄甜玉米煮熟，取出，再放入烤箱中以180℃烤约5∼8分钟至上色后，取出切成小段片状\",\n" +
				"        \"fcount\": 0,\n" +
				"        \"food\": \"甜玉米,莴苣,小蕃茄,高汤,油醋汁\",\n" +
				"        \"id\": 25019,\n" +
				"        \"images\": \"\",\n" +
				"        \"img\": \"/cook/080301/21fc7d8f7cbfc0ab3816abc0c9ef46fc.jpg\",\n" +
				"        \"keywords\": \"甜玉米 放入 材料 法式 高汤 \",\n" +
				"        \"name\": \"烤玉米沙拉\",\n" +
				"        \"rcount\": 0\n" +
				"    },\n" +
				"    {\n" +
				"        \"count\": 40,\n" +
				"        \"description\": \"将红豆洗净，泡水3小时后煮沸，大滚后转成小火煮40分钟至软，再将红豆捞出分装在模型小碗内备用\",\n" +
				"        \"fcount\": 0,\n" +
				"        \"food\": \"红豆,椰浆,洋菜\",\n" +
				"        \"id\": 25020,\n" +
				"        \"images\": \"\",\n" +
				"        \"img\": \"/cook/080301/36871fa195122f56adcd6272b628ced4.jpg\",\n" +
				"        \"keywords\": \"红豆 洋菜 煮沸 洗净 模型 \",\n" +
				"        \"name\": \"椰汁红豆冻\",\n" +
				"        \"rcount\": 0\n" +
				"    },\n" +
				"    {\n" +
				"        \"count\": 40,\n" +
				"        \"description\": \"放入铜锅，以小火慢慢煮至118℃，颜色变成牛奶糖颜色（可以用核桃沾牛奶糖来测试，若可拉出1cm的黏丝，即表示完成），迅速拌入核桃，将所有的核桃裹上牛奶糖，等到所有核桃拌匀后，趁热将坚果馅倒入塔皮中将表面整型，入炉\",\n" +
				"        \"fcount\": 0,\n" +
				"        \"food\": \"蜂蜜,鲜奶油,奶油,核桃\",\n" +
				"        \"id\": 25021,\n" +
				"        \"images\": \"\",\n" +
				"        \"img\": \"/cook/080301/98f219f4c9a5155a4d69100fb6e6ab48.jpg\",\n" +
				"        \"keywords\": \"核桃 牛奶糖 颜色 材料 所有 \",\n" +
				"        \"name\": \"核桃塔\",\n" +
				"        \"rcount\": 0\n" +
				"    },\n" +
				"    {\n" +
				"        \"count\": 40,\n" +
				"        \"description\": \"用打蛋器先将奶油搅拌成乳霜状，将材料中的粉料倒入拌匀，分次加入蛋汁搅拌成为浓稠状\",\n" +
				"        \"fcount\": 0,\n" +
				"        \"food\": \"杏仁,低筋面粉,无盐奶油,蛋液\",\n" +
				"        \"id\": 25022,\n" +
				"        \"images\": \"\",\n" +
				"        \"img\": \"/cook/080301/2c20b99cc02baf719b4b4d7a4037163d.jpg\",\n" +
				"        \"keywords\": \"奶油 杏仁 搅拌 面粉 打蛋器 \",\n" +
				"        \"name\": \"杏仁塔\",\n" +
				"        \"rcount\": 0\n" +
				"    },\n" +
				"    {\n" +
				"        \"count\": 40,\n" +
				"        \"description\": \"将细砂糖、蜂蜜、鲜奶油放入铜锅，以小火慢慢煮至118℃，颜色变成牛奶糖颜色\",\n" +
				"        \"fcount\": 0,\n" +
				"        \"food\": \"蜂蜜,鲜奶油,奶油,坚果\",\n" +
				"        \"id\": 25024,\n" +
				"        \"images\": \"\",\n" +
				"        \"img\": \"/cook/080301/57fc234b2aefb5ff07b46a771a0ce811.jpg\",\n" +
				"        \"keywords\": \"坚果 牛奶糖 鲜奶油 颜色 所有 \",\n" +
				"        \"name\": \"坚果塔\",\n" +
				"        \"rcount\": 0\n" +
				"    },\n" +
				"    {\n" +
				"        \"count\": 40,\n" +
				"        \"description\": \"制作内馅：将牛奶中加入材料中的细砂糖、盐，以小火煮至快要沸腾即关火，冷却备用\",\n" +
				"        \"fcount\": 0,\n" +
				"        \"food\": \"牛奶,全蛋,蛋黄\",\n" +
				"        \"id\": 25028,\n" +
				"        \"images\": \"\",\n" +
				"        \"img\": \"/cook/080301/9172f46ff9d6cc00d871cd60b1229727.jpg\",\n" +
				"        \"keywords\": \"细砂糖 牛奶 冷却 适量 玉米粒 \",\n" +
				"        \"name\": \"玉米塔\",\n" +
				"        \"rcount\": 0\n" +
				"    },\n" +
				"    {\n" +
				"        \"count\": 40,\n" +
				"        \"description\": \"炒锅加油烧热放入西兰花煸炒一会，加盐糖，放入红腰豆，加少许水煮一会，淋上湿芡粉勾芡即可3\",\n" +
				"        \"fcount\": 0,\n" +
				"        \"food\": \"西兰花,红腰豆,芡粉\",\n" +
				"        \"id\": 78295,\n" +
				"        \"images\": \"\",\n" +
				"        \"img\": \"/cook/080319/0ab393297de4340b1299d29fa4ca705a.jpg\",\n" +
				"        \"keywords\": \"西兰花 一会 芡粉 放入 用水 \",\n" +
				"        \"name\": \"西兰花烩红腰豆\",\n" +
				"        \"rcount\": 0\n" +
				"    },\n" +
				"    {\n" +
				"        \"count\": 40,\n" +
				"        \"description\": \"将作法4取出，静置至完全冷却，取出分切成3片（每片约20×40公分），分别抹上打发的鲜奶油并捲起成3条40公分长的蛋糕捲，移入冰箱冷冻约2小时\",\n" +
				"        \"fcount\": 0,\n" +
				"        \"food\": \"低筋面粉,玉米粉,泡打粉,香草粉,沙拉油,蛋黄,蛋白,塔塔粉,奶油,白兰地,打发鲜奶油\",\n" +
				"        \"id\": 25032,\n" +
				"        \"images\": \"\",\n" +
				"        \"img\": \"/cook/080301/9fbaf699039bcd6f2eb47734e6e83ac5.jpg\",\n" +
				"        \"keywords\": \"作法 鲜奶油 材料 白兰地酒 取出 \",\n" +
				"        \"name\": \"栗子蛋糕\",\n" +
				"        \"rcount\": 0\n" +
				"    }\n" +
				"]}";

		Gson gosn = new Gson();
//
//		CookBean cookBeen = gosn.fromJson(data,CookBean.class);
//
//		List<CookBean.TngouBean> lists = cookBeen.getTngou();

		//foodAdapter = new FoodAdapter(lists,getContext());

		//recyclerView.setAdapter(foodAdapter);

	}


	void  showData(){

//		Retrofit retrofit = new Retrofit.Builder()
//				.baseUrl("http://172.24.10.130:8080/")
//				.addConverterFactory(GsonConverterFactory.create())
//				.build();
//
//		final Apiservice infoApi = retrofit.create(Apiservice.class);
//
//		Call<List<SchoolFood>> call =  infoApi.getSchoolFood();
//
//		call.enqueue(new Callback<List<SchoolFood>>() {
//			@Override
//			public void onResponse(Call<List<SchoolFood>> call, Response<List<SchoolFood>> response) {
//				if(response.isSuccessful()){
//
//					List<SchoolFood> infoBean = response.body();
//
//					foodAdapter = new FoodAdapter(infoBean,getContext());
//
//					recyclerView.setAdapter(foodAdapter);
//				}
//			}
//
//			@Override
//			public void onFailure(Call<List<SchoolFood>> call, Throwable t) {
//				t.printStackTrace();
//			}
//		});

	}
}
