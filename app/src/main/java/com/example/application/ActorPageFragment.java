package com.example.application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;



public class ActorPageFragment extends Fragment{
    private ImageView posters;
    private TextView personName, intro, intros;
    Map<String, String> actor_details;
    public String actor_name;

    private int[] images = {
            R.drawable.img_0,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6,
            R.drawable.img_7,
            R.drawable.img_8,
            R.drawable.img_9,
            R.drawable.img_10,
            R.drawable.img_11,
            R.drawable.img_12,
            R.drawable.img_13,
            R.drawable.img_14,
            R.drawable.img_15,
            R.drawable.img_16,
            R.drawable.img_17,
            R.drawable.img_18,
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Text view
        try {
            actor_name = getArguments().getString("ACTOR");
        }
        catch (java.lang.NullPointerException e){
            actor_name  = "";
        }

        actor_details = new HashMap<String, String>();

        actor_details.put("左己", "   在众多粤语片导演中，左几出品最多（共为国际/电懋执导十七部作品），个人风格最为突出，所作的尝试也最大胆。有别于当时通俗、保守的粤语片，他对场面调度及叙事法度均驾驭纯熟，在电影语言及取材上具有作者风范。左几富文学修养，注重人物心理刻画，偏好文艺片，曾大胆将不少经典名著重新演绎。他的民初、时装片同样奇情偏锋，对病态人性及疯狂恋爱的刻划，比同期的粤语片都超前大胆。");
        actor_details.put("张瑛","    原名张溢生，1919年1月25日出生于香港，由于在家族兄弟姊妹中排行第十四，因此圈中人称他为“十四叔”。\n   张瑛幼随父到香港。就读于华仁书院。1984年底在美国逝世，享年65岁。他是香港粤语片时代的演员，李小龙还是童星时常出现在他主演的电影中。并和其余三位粤语片演员吴楚帆、张活游和李清合称为“粤语片四大小生”。");
        actor_details.put("白燕","    原名陈玉屏，广东人。1936年考入广州国际影片公司，从此走上演员之路，1937年到香港演出第一部电影《锦绣河山》。\n    白燕擅长演绎遭遇不幸的女性和端庄娴淑的贤妻良母，形象鲜明，与吴楚帆、张瑛、张活游合作最多。主演的名片包括：《蝴蝶夫人》（1940）、《春》（1953）、《寒夜》（19 55）、《春残梦断》（1955）、《豪门夜宴》（1959）、《人海孤鸿》（1960）、《可怜天下父母心》（1960）、《回魂夜》（1962）、《孽海遗恨》上、下集（1962）、《沧海遗珠》（1965）等等。\n" +
                "   1952年，白燕与著名演员吴楚帆、张活游、黄曼梨等创办「中联电影企业有限公司」，以制作优质电影为宗旨，力拒当时电影界「七日鲜」粗制滥造和「伶星不分家」的潮流，成绩昭著。1964年演罢《疯妇》後退出艺坛，1987年5月6日因骨癌病逝香港，享年六十七岁。著有自传《锦绣青春》。");
        actor_details.put("金山","    1911年8月9日—1982年7月7日），原名赵默，出生于江苏省苏州市，祖籍湖南省怀化市沅陵县，中国内地演员、导演、编剧、制作人，上海徐汇公学肄业。\n" +
                "   1935年，主演个人首部电影《昏狂》。1937年，主演爱情电影《夜半歌声》。1942年，在话剧《屈原》中饰演屈原。1947年，自编自导抗战电影《松花江上。1948年，担任剧情电影《小白龙》的制作人。1950年，主演话剧《保尔·柯察金》。1954年，参演话剧《万尼亚舅舅》。1959年，自编自导自演革命电影《风暴》。1978年，执导话剧《于无声处》。\n" +
                "   1982年7月7日，金山因突患脑溢血而逝世，享年71岁。2005年，在中国电影诞生100年之际，金山被评为“中国电影百位优秀演员”。");

        actor_details.put("浦克","   (1916年1月11日—2004年3月17日），出生于山东省烟台市蓬莱县，中国内地演员，毕业于辽宁本溪县立中学。\n" +
                "   1939年，参演个人首部电影《真假姐妹》，从而开启了他的演员生涯 。1942年，主演剧情电影《迎春花》。1947年，主演剧情电影《松花江上》。1950年，出演剧情电影《吕梁英雄》。1956年，在喜剧电影《新局长到来之前》中饰演新任局长张局长。1962年，在剧情电影《甲午风云》中饰演提督丁汝昌。1964年，出演战争电影《英雄儿女》。1973年，在剧情电影《艳阳天》中饰演主任马之悦。1978年，出演剧情电影《严峻的历程》。1984年，出演剧情电影《黄山来的姑娘》。1987年，由其出演的战争电影《关东大侠》上映。1991年，浦克获得第3届金凤凰奖特别荣誉奖 。1993年，由其参演的武侠电影《雪国情仇》上映。2004年3月17日，浦克逝世，享年88岁。");
        actor_details.put("朱文顺","   朱文顺，中国老一代电影导演。他是一位扎实多产的电影导演。他在新中国建立前的早期电影创作活动，是他电影生涯中的重要历史阶段。朱文顺任职场工、剧务助理、导演助理、剧务主任、剪辑科长、副导演到导演，从影54年，执导拍摄电影33部，电视连续剧2部，电视单本剧5部13集。\n   八十年代，他导演了影片《刀光虎影》、《何处不风流》、《拂晓的爆炸》、《鞘中之剑》、《初恋时我们不懂爱情》、《飘忽的影子》等。1995年去世，终年75岁。");
        actor_details.put("方化","    （1925年10月17日—1994年11月7日），出生于辽宁大连。中国内地演员。\n" +
                "   1947年，出演了电影处女作《松花江上》。1950年，出演了由沙蒙执导的传记电影《赵一曼》。1954年1月，主演的战争电影《智取华山》上映。1955年，主演的战争电影《平原游击队》上映，凭借该片获得了“文化部1949－1955年优秀影片最佳表演奖” 。1957年，出演了讽刺喜剧片《没有完成的喜剧》。1960年6月，出演的战争电影《铁道卫士》上映。1962年，出演了战争电影《甲午风云》。1965年，出演了抗日电影《三进山城》。1974年，主演了战争电影《平原游击队》。1978年7月，主演的战争电影《山寨火种》上映。1980年，出演的谍战惊险片《与魔鬼打交道的人》上映。1988年，出演了古装电影《南岭传奇》。1989年，主演了抗战电影《逢凶化吉》。1994年，出演了剧情片《阳光灿烂的日子》。\n" +
                "   1994年11月7日，方化因病去世，终年69岁。");
        actor_details.put("张瑞芳","   （1918年6月15日—2012年6月28日），原籍北京市，出生于河北省保定市，中国内地女演员。\n" +
                "   1940年，参演个人首部电影《火的洗礼》。1946年，在剧情电影《松花江上》中饰演村姑妞儿。1952年，在战争电影《南征北战》中饰演游击队长赵玉敏。1958年，主演剧情电影《三八河边》。1962年，凭借剧情电影《李双双》获得第2届电影百花奖最佳女演员奖。1964年，主演剧情电影《李善子》。1976年，参演剧情电影《年青的一代》。1978年主演《大河奔流》。1982年，由其主演的儿童电影《泉水叮咚》上映。1986年，出演剧情电影《T省的84·85年》。\n" +
                "   1993年，张瑞芳获得中国电影表演艺术学会特别荣誉奖。2003年，张瑞芳获得第9届中国电影表演艺术学会金凤凰奖终身成就奖。2007年，张瑞芳获得第10届上海国际电影节华语电影终身成就奖。2012年6月28日，张瑞芳因病在上海华东医院逝世，享年94岁。");
        actor_details.put("卜万苍","   （1903年-1974年），中国电影导演，安徽天长人；主要作品有《三个摩登女性》、《母性之光》、《国魂》。\n    安徽天长人。扬州第五师范肄业。1921年入中国影戏制造公司，从美国籍摄影师哥尔金学习摄影，并拍摄短片《饭桶》。1924年后任大中华、明星影片公司摄影师，拍摄默片《人心》 、《新人的家庭》等。1926年任民新 影片公司剧务主任兼导演。执导的第 一部影片为《玉洁冰清》。1931年任 联华影业公司导演，因执导《恋爱与义务》而知名。后相继导演《三个摩登女性》、《母性之光》，在艺华影业公司导演《黄金时代》、《凯歌》 等影片，均获好评。上海沦为“孤岛 ”后在新华、华成等影片公司导演古装影片《木兰从军》、《西施》等。 1942年入中华联合制片股份有限公司 ，参与执导《万世流芳》、《博爱》等影片。1948年任香港永华影业公司 导演，执导影片《国魂》。1950年创 办泰山影片公司。他在香港各影片公 司导演的较有影响的影片尚有《长巷》、《一夜风流》、《苦儿流浪记》 等。60年代为台湾制片厂导演的《吴凤》，为台湾第一部彩色宽银幕故事片；《梁红玉》为台湾第一部彩色京剧戏曲片。1964年在台湾导演《赵五娘》后退出影坛。");
        actor_details.put("王元龙","   1903～1969），男，著名演员、编导，原名王秉钰，出生于天津，1924年出演处女作《人心》，素有“银坛霸王”之称。 王元龙家有兄弟姊妹好几个，其弟王次龙也是由他介绍从影的。其父四川成都人，经营盐业，家庭富有。王元龙从小受过良好教育，1922年毕业于保定陆军大学。两年后他离开军队涉足影坛，主演了《人心》《战功》《王氏四侠》《透明的上海》等片，以粗犷硬朗的英雄形象深受观众欢迎，成为当时影坛的首席男明星，人称“银坛霸王”。王元龙成名后，生活上放荡不羁，桃色新闻不断，声誉直线下降，整个30年代，只有一部《还我山河》稍有影响。进入40年代，古装片热兴起，王元龙主演了《楚霸王》、《燕子盗》等片，重受欢迎。以后，他虽然一直从影，但成绩平平，昔日“银坛霸王”的风采已一去不复返了。1969年，他在台湾病逝。代表作有《王氏四侠》（1927）、《楚霸王》、《江湖儿女》等。");
        actor_details.put("梅熹","    (1914～1983)梅成栋的次子梅宝璐之孙。中国电影演员、导演。他在天津长大，从小喜爱体育运动，练就一幅高大魁梧的身材。曾被北平一所中学聘为体育教员。后来他来到上海，想成为一名演员，为此他曾找到了费穆，但影片公司嫌他过于高大而拒绝了他。1933年，他终于被明星影片公司录取，进入该公司的演员养成所受训。毕业后，他在李萍倩导演的《丰年》中饰演重要角色，一炮打响，获得成功。\n    1938年到1942年是他的黄金时代，在“新华”、“华新”、“华成”、“艺华”等主演了三十多部影片，其中《乞丐千金》、《木兰从军》等影片都轰动一时，《木兰从军》一片使梅熹成为当年最卖座的红小生。抗战期间，他曾拍摄过反动影片，受到抨击。此后，他便退出影坛，从事商业，却商场失利，不得不于1948年重返影坛，又拍摄了《雾夜血案》、《断肠相思》等影片。北平解放后，他来到北平，加入文工团，演出了《白毛女（话剧）》、《刘胡兰（话剧）》等。1963年，他被调到北京电影制片厂任导演，他参加拍摄了《风暴》、《停战以后》等影片，1979年在西安电影制片厂拍摄了《乳燕飞》。1983年他病逝于北京。");
        actor_details.put("白虹","    （1920年2月24日～1992年5月28日），原名白丽珠，民国时期著名歌唱家、演员。1931年初成为明月歌舞团成员，1934年在播音歌星竞选中夺冠，成为中国流行音乐史上第一位“歌唱皇后”。1945年1月举办歌唱大会，是第一位举办个人演唱会的内地流行歌星。作为上海时期的影剧歌三栖红星，白虹灌录歌曲150余首，数量仅次于周璇，是40年代七大歌星、30年代末三大歌星之一；出演《无花果》《孤岛春秋》《美人关》《雾夜血案》等30多部影片以及《上海之歌》《杨贵妃》等舞台剧、歌剧和话剧，在电影界与白光、白杨并称“北平三白”。建国后白虹致力于话剧事业直至退休，曾荣获三等功。");
        actor_details.put("王献斋","   曾开设眼科诊所，后弃医从影。因所开眼科诊所与明星影片公司相邻，得以结识众多影人。后得张石川介绍进入影界，拍摄了《滑稽大王游沪记》。随后主演影片《孤儿救祖记》等，因成功饰演反派人物而蜚声影坛。... 在《孤儿救祖记》、《歌女红牡丹》、《劫后桃花》等影片中出演反派角色，是中国电影史上第一位以饰演反派著称的著名影星，被誉为“第一坏蛋”和“无赖标本”。当时舆论界曾这样评论“在当今电影圈内饰演反派角色，演技的圆熟，深度达到‘炉火纯青’者唯王献斋一人。”");
        actor_details.put("舒绣文","   （1915年—1969年3月17日），出生于安徽省安庆市，原籍安徽省黟县九都舒村，中国内地演员。\n" +
                "   1933年，出演个人首部电影《民族生存》。1935年，主演剧情电影《夜来香》。1938年，主演剧情电影《保卫我们的土地》。1946年，在剧情电影《一江春水向东流》中饰演交际花王丽珍 。1948年，主演剧情电影《野火春风》 [2]  。1952年，为动画短片《小猫钓鱼》配音。1956年，出演古装剧情电影《李时珍》。1957年，调入北京人民艺术剧院担任演员。1958年，参演话剧《关汉卿》。\n" +
                "   1969年3月17日，舒绣文逝世，终年54岁 。2005年，在中国电影诞生100年之际，舒绣文被评为“中国电影百位优秀演员” 。2009年，关于她的自传《舒绣文传》出版。");
        actor_details.put("程步高","   1898～1966）中国电影导演，字齐东。浙江嘉兴平湖人。\n" +
                "   程步高早年求学于私立诒谷小学，后考入上海震旦大学，在上海震旦大学读书时曾为《时事新报》副刊撰写影评，翻译介绍国外电影技术知识。在上海震旦大学未毕业即回平湖，任教于登瀛小学。1922年去上海，1924年起涉足影坛，从事电影编导。1966年6月20日卒于香港。\n");
        actor_details.put("夏萍","    1937年10月6日-2019年8月5日），原名卢少萍。英文名：Teresa，后用Apple，生于中国香港。香港甘草演员、TVB资深艺人。\n" +
                "   夏萍二次大战时曾到中国内地居住，至战后回港。1955年，夏萍投考电影公司成为演员，1970年加入邵氏电影拍片13年，1982年加入无线电视。加入电视圈后，演出人母甚至祖母级角色，横跨演艺圈60年，是圈中出名金牌绿叶的老戏骨。2005年在TVB台庆晚会上，夏萍击败汪明荃获得了TVB万千光辉演艺大奖（相当于终身成就奖）。\n" +
                "   2019年8月5日，夏萍安详离世，享年81岁。");
        actor_details.put("黄曼梨","   （Mary Wong，1913年-1998年4月8日），原名黄文素，曾名黄曼丽，生于香港，广东中山人。香港著名粤语电影、电视演员，电影、电视作品无数，经常在电影里演恶家姑的角色。但在早期也演过不少贤妻良母、小家碧玉和大家闺秀的角色。其精湛演技及深厚的修养内涵，赢得“悲剧影后”美誉。");
        actor_details.put("姜中平","   （1922年9月6日-1999年12月28日），著名甘草演员、监制、策划。第二次世界大战期间，当过兵，在军队中参与文娱工作。1947年正式加入电影圈，出演电影上百部，多饰演配角。70年代减少电影演出，开始转为幕后从事电影的监制、策划工作。1984年经诊断患喉癌，期间仍参演过电影《倾城之恋》和《歌舞瘅平》的拍摄，1989年，在香港施行声带手术後即移居芝加哥休养。期间参与了《奸人本色》、《亡命天涯》、《少女心》等电影的拍摄，因癌细胞扩散返港定居。最后一次出演电影是1999年的《天使之城》。1999年12月28日，因肾衰与世长辞，享年七十七岁。");

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_actor_page, container, false);

        posters = rootView.findViewById(R.id.person);
        personName = rootView.findViewById(R.id.name);
        intro = rootView.findViewById(R.id.intro1);
        intros = rootView.findViewById(R.id.intro2);

        String introduction;
        switch (actor_name) {
            case "左己":
                introduction = actor_details.get("左己");
                posters.setImageResource(images[0]);
                break;
            case "张瑛":
                introduction = actor_details.get("张瑛");
                posters.setImageResource(images[1]);
                break;
            case "白燕":
                introduction = actor_details.get("白燕");
                posters.setImageResource(images[2]);
                break;
            case "金山":
                introduction = actor_details.get("金山");
                posters.setImageResource(images[3]);
                break;
            case "浦克":
                introduction = actor_details.get("浦克");
                posters.setImageResource(images[4]);
                break;
            case "朱文顺":
                introduction = actor_details.get("朱文顺");
                posters.setImageResource(images[5]);
                break;
            case "方化":
                introduction = actor_details.get("方化");
                posters.setImageResource(images[6]);
                break;
            case "张瑞芳":
                introduction = actor_details.get("张瑞芳");
                posters.setImageResource(images[7]);
                break;
            case "卜万苍":
                introduction = actor_details.get("卜万苍");
                posters.setImageResource(images[8]);
                break;
            case "王元龙":
                introduction = actor_details.get("王元龙");
                posters.setImageResource(images[9]);
                break;
            case "梅熹":
                introduction = actor_details.get("梅熹");
                posters.setImageResource(images[10]);
                break;
            case "白虹":
                introduction = actor_details.get("白虹");
                posters.setImageResource(images[11]);
                break;
            case "王献斋":
                introduction = actor_details.get("王献斋");
                posters.setImageResource(images[12]);
                break;
            case "舒绣文":
                introduction = actor_details.get("舒绣文");
                posters.setImageResource(images[13]);
                break;
            case "程步高":
                introduction = actor_details.get("程步高");
                posters.setImageResource(images[14]);
                break;
            case "夏萍":
                introduction = actor_details.get("夏萍");
                posters.setImageResource(images[15]);
                break;
            case "黄曼梨":
                introduction = actor_details.get("黄曼梨");
                posters.setImageResource(images[16]);
                break;
            case "姜中平":
                introduction = actor_details.get("姜中平");
                posters.setImageResource(images[17]);
                break;
            default:
                introduction = "无相关演员信息";
        }

        personName.setText(actor_name);
        intro.setText("基本信息");
        intros.setText(introduction);

        return rootView;
    }
}



