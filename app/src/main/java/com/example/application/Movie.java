package com.example.application;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.Map;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.application.util.DownloadImageUtil;


public class Movie extends Fragment {
    private  String MOVIE_NAME = "";
    private  String MOVIE_IMAGE = "";
    private  String MOVIE_URL = "";
    //private ImageView image;
    private TextView intro, introDetail, filmName;
    Map<String, String> film_details = new HashMap<String, String>();
    private ImageView imageView;
    private DownloadImageUtil downloadImageUtil;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            MOVIE_NAME = getArguments().getString("NAME");
            MOVIE_IMAGE = getArguments().getString("IMAGE");
            MOVIE_URL = getArguments().getString("URL");
        }
        catch (java.lang.NullPointerException e){
            MOVIE_NAME = "";
            MOVIE_IMAGE = "";
            MOVIE_URL = "";
        }

        //((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(MOVIE_NAME);
        downloadImageUtil = new DownloadImageUtil(getActivity());
        film_details.put("秦淮世家", "  《秦淮世家》是1963年上映的香港影片，由左几执导，张瑛、白燕主演。 影片讲述秦淮两岸，各种形形色色的人，他们生活状态的故事：\n   小说家徐亦进撞破王大狗扒去唐大姑钱包，大家不打不相识，亦进劝服大狗物归原主。唐家世代弹唱为业，大姑女儿二春早已卸下歌衫，幼女小春红极一时。二春与亦进互有好感，而小春暗地请亦进代传书给情人陆影，亦进见陆影轻佻浮躁，借机揭穿陆影的把戏。\n" +
                "   督办杨育权粗鲁好色，对小春咄咄相逼。小春逃走，却遭陆影出卖，给育权禁锢。亦进为救小春，亦同样被囚。二春救人心切，身入虎穴。偷得育权手枪负隅顽抗，此时亦进、大狗等人群情激奋地冲入督办府，打倒专横的育权。");

        film_details.put("松花江上","   《松花江上》是由金山执导，张瑞芳、浦克、朱文顺等主演的剧情片。\n   影片讲述了在东北松花江畔的一个小村庄里，人们都盼望着来年丰收的年景。一个青年和一个大汉赶着粮食车到集市上出售，傍晚时分，两人赶着车在一个车店门前停下，青年早已和车店店家的孙女相爱，店家家中还有女孩的祖父和父母。第二天早晨，青年又得赶车出发，他和孙女相约下次再见面。\n" +
                "   不久，“九一八”爆发日本侵入东北，打破本来平静和谐的生活。孙女的母亲被日本人推入松花江中，父亲也被马踩死，为此祖父一病不起。而青年被抓走，半途中大汉带领义勇军偷袭日寇，青年趁乱逃到车店。后来，大汉也来到车店，后将日寇的军营炸毁。日寇逼迫村民为他们修筑碉堡，孙女为人们送饭途中碰见好色的日寇伍长，伍长欲污辱她，这时青年赶来，将伍长打死。于是，青年带着孙女和祖父逃离此地，但半路上祖父去世，临终前要青年和孙女结为夫妻。青年为谋生去日寇煤矿做苦工。七七事变后，煤矿工人由于日寇强迫增加产量，造成矿井塌陷。日寇又镇压人们，青年、孙女在大汉的帮助下逃出这里，终于参加了义勇军，抗击日寇。");
        film_details.put("潇湘夜雨","   《潇湘夜雨》是1940年上映的中国大陆爱情电影，由卜万苍执导，王元龙、梅熹、白虹等主演。 《潇湘夜雨》讲述了青年张又新与纯洁少女秋兰私定终身，但后来与远房表妹玛莉结婚。经过一翻波折，最后重逢秋兰，一家人终于团聚。");
        film_details.put("新旧上海","   《新旧上海》是程步高执导，洪深编辑的剧情片，1936年上映，由舒绣文、王献斋、黄耐霜主演。影片讲述了在一座鸽子笼似的弄堂房里，住着六户人家：楼上统厢房住的是已被停职的某丝厂职员袁瑞三（王献斋饰）和他的会做人的太太（舒绣文饰），袁瑞三虽然失业已久，却硬撑着门面，装出并未失业的样子；客堂楼住的是两名舞女孙如梅和俞连珠，她们虽然每天到舞厅去，可是舞厅里舞客寥寥，只有“汤口”可吃；亭子间里住的是汽车夫唐根泰，他的主人在事业上“兜不转”，致使他闲来无事，终日开着小车，载着女人乱转；阁楼上住的是小学教员陈老师，由于校方欠薪太久，加上卖文无路，使他异常焦急；楼下统厢房住的是范思全夫妇，男的在一家木器店当跑街，但拉不到生意，女的多产又多病，整天守着一群孩子；后客堂住的则是二房东吕老太婆和她的喜欢赌博的儿子。这样一些“灰色人物”，聚居在这样一种“灰色环境”里。人人，家家，时时，处处，都缠绕在一种难解的愁绪和郁闷的气氛里。");
        film_details.put("满江红","    香港电影《满江红》由华侨电影企业有限公司于1962年出品。该片由左几执导，张瑛、白燕、夏萍、黄曼梨、杨茜、姜中平等领衔主演。影片讲述了美术教师于水村与歌女桃枝的爱情故事。影片中，黄学贤是一富教育理想的中学教员，然而物价高涨，学贤与妻子慧冰饱受生活窘迫。儿子黄冲高中尚未毕业便被迫辍学，任职于一所平民夜校，而八岁女儿黄清则交予其弟仲豪抚养。本寄居黄家的甥女小玲亦被迫到学贤老同学方光宗家当佣工。方光宗初任校董，但儿子耀祖因在校内行为放肆，欺负女同学而被学贤记下大过。其后黄冲因小玲求学的问题与方太太争执，方光宗一怒之下运用势力勒令停办夜校，随后学贤更被校方辞退，生活捉襟见肘。岂料祸不单行，仲豪意外被机器辗毙，慧冰求助于光宗不果，幸获工友捐助，才筹足殓葬费用。学贤至此悲从中来，彷徨地步至珠江桥上欲自寻短见。与此同时，其子黄冲得街坊资助重办义学，开学礼之日，众人正等学贤回来，惟到入夜还不见其踪，黄冲寻至桥上，及时把父亲救回。学贤见小孩天真可爱，再次坚定新生的决心，和儿子一起重投教育事业。");
        film_details.put("血泪黄花","   电影《血泪黄花》是明星影片公司以1928年发生在上海的黄慧如、陆根荣主仆情奔案件为原形为创作的黑白默片。");
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_movie, container, false);
        //image = findViewById(R.id.poster);
        filmName = rootView.findViewById(R.id.movie_name);
        intro = rootView.findViewById(R.id.movie_intro);
        introDetail = rootView.findViewById(R.id.movie_intro_details);
        imageView = rootView.findViewById(R.id.movieimage);

        String introduction;
        switch (MOVIE_NAME) {
            case "秦淮世家":
                introduction = film_details.get("秦淮世家");
                break;
            case "松花江上":
                introduction = film_details.get("松花江上");
                break;
            case "潇湘夜雨":
                introduction = film_details.get("潇湘夜雨");
                break;
            case "新旧上海":
                introduction = film_details.get("新旧上海");
                break;
            case "满江红":
                introduction = film_details.get("满江红");
                break;
            case "血泪黄花":
                introduction = film_details.get("血泪黄花");
                break;
            default:
                introduction = "无相关影片";
        }

        filmName.setText(MOVIE_NAME);
        intro.setText("简介");
        introDetail.setText(introduction);
//        if (imageView == null){
//            MOVIE_IMAGE = "0";
//        }
//        if (MOVIE_IMAGE == null){
//            MOVIE_IMAGE = "0";
//        }
        downloadImageUtil.downloadImage(MOVIE_IMAGE,imageView);

        return rootView;
    }
}




