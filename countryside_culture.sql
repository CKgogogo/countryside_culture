/*
Navicat MySQL Data Transfer

Source Server         : 47.95.218.93_3306
Source Server Version : 50726
Source Host           : 47.95.218.93:3306
Source Database       : countryside_culture

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-07-13 15:47:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `activity`
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `keyword` varchar(255) DEFAULT NULL,
  `content` text,
  `eorganizer` varchar(255) DEFAULT NULL,
  `eventdate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------

-- ----------------------------
-- Table structure for `address_info`
-- ----------------------------
DROP TABLE IF EXISTS `address_info`;
CREATE TABLE `address_info` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `telephone` int(20) DEFAULT NULL,
  `defaultAddress` int(20) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address_info
-- ----------------------------

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `uid` int(22) NOT NULL,
  `username` varchar(22) NOT NULL,
  `password` varchar(22) NOT NULL,
  `add_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for `admin_role`
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role` (
  `id` int(22) NOT NULL,
  `uid` int(22) NOT NULL,
  `rid` int(22) NOT NULL,
  `status` int(22) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_role
-- ----------------------------

-- ----------------------------
-- Table structure for `headlines`
-- ----------------------------
DROP TABLE IF EXISTS `headlines`;
CREATE TABLE `headlines` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` int(11) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `publish_time` varchar(255) DEFAULT NULL,
  `content` text,
  `introduction` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of headlines
-- ----------------------------

-- ----------------------------
-- Table structure for `museum`
-- ----------------------------
DROP TABLE IF EXISTS `museum`;
CREATE TABLE `museum` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `kind` int(11) DEFAULT NULL,
  `title` varchar(22) DEFAULT NULL,
  `content` text,
  `remark` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of museum
-- ----------------------------
INSERT INTO `museum` VALUES ('1', '1', '单仰萍', '单仰萍，浙江桐庐（也有说法为建德）人，浙江省桐庐中学毕业。|1972年1月进入桐庐艺训班学戏，工旦角，后为桐庐越剧团主要演员。1984年7月，随桐庐越剧团首次到上海，主演《春江月》。1985年11月，随杭州市越剧二团再次到上海，主演《桐江雨》。后该两剧拍摄成戏曲艺术影片（片名为《绣花女传奇》和《桐江雨》），仍由她主演，表演上宗王（文娟）派。|1988年至1993年进入上海越剧院红楼团演戏。1998年再次进入红楼团。', '越剧一级演员', 'team5.jpg', 'id');
INSERT INTO `museum` VALUES ('2', '6', 'QQ', '绍兴女子文戏科班。1933年7月由嵊县杜联等人合股举办。班址在嵊县四明乡后城村(后移至上江村)。学艺期限定为三年半。招徒30余人，由钟加昌、金荣水为教戏师傅，开蒙戏为《仁义缘》、《红桃山》。六个月后，以尹树春(生)、吴梅珍(旦)、叶樟老(老生)、丁兆丰(丑)为“四柱头”，到浦口镇里东山区和绍兴水乡边演边学艺。后又教了《御碑亭》、《玉连环》、《四香缘》、《碧玉簪》、《二度梅》、《梁山伯与祝英台》等。在绍兴孙端镇时，适遇大王舞台、四季春科班同在一地演出，互相斗台竞艺，阳春舞台获得盛誉。1935年因股东不和，金荣水被迫离去，科班转卖给嵊县华堂镇王伯根，1936年下半年满师后散班。', null, 'project1.jpg', null);
INSERT INTO `museum` VALUES ('3', '2', '越剧服装·箭衣', '箭衣，式样参考清朝官服。圆领大襟，马蹄袖，前后开叉齐腰。分为龙箭衣、花箭衣、素箭衣三种。龙箭衣为帝王、将帅的军便服，绣团龙、海水等纹饰，颜色有红、黄、白、黑、绿、紫等多种；花箭衣为一般英雄好汉和武将的便服，绣团花和其他纹样；素箭衣为公差、老军所穿，分黑、蓝两色。|', null, 'clo1.png', null);
INSERT INTO `museum` VALUES ('4', '2', '越剧服装·箭衣', '箭衣，式样参考清朝官服。圆领大襟，马蹄袖，前后开叉齐腰。分为龙箭衣、花箭衣、素箭衣三种。龙箭衣为帝王、将帅的军便服，绣团龙、海水等纹饰，颜色有红、黄、白、黑、绿、紫等多种；花箭衣为一般英雄好汉和武将的便服，绣团花和其他纹样；素箭衣为公差、老军所穿，分黑、蓝两色。', null, 'clo2.jpg', null);
INSERT INTO `museum` VALUES ('5', '3', '越剧道具·刀枪把子', '刀枪把子，指越剧舞台上武打兵器。它来自于古代的兵器，但经过艺术加工，更适合在舞台上使用。越剧的刀枪把子有可分为枪、刀、剑、戟、斧、杈、鞭、锏、锤、棍棒、弓箭及其他等12类。|枪，越剧武打戏中经常使用的一种道具，属于长兵器，大多适用于马戏武打。分为大枪、二枪、单枪、荷包样枪、霸王枪、哪吒枪等。|刀，越剧武打戏中经常使用的一种道具。分大刀类和短刀类。大刀类属于长兵器，有大刀、象鼻刀、青龙刀、三耳大刀、坤大刀、开门刀等；短刀类属于短兵器，有单刀、双刀、扑刀、坤刀、腰刀、狼牙刀、鬼头刀等。|剑，在越剧舞台上使用很广泛，可做战场上的兵器，也可配带在贤人志士身上做驱邪惩恶的圣物，在王公贵族手中则是权利的象征。属于短兵器，有单剑、双剑、人字剑、鱼皮剑、尚方宝剑、蛇剑等。|戟，大多为长兵器，只有少量短兵器。有单戟、双戟、方天画戟、双头大戟等。|斧，越剧舞台上为威猛的花脸一类角色使用。有长柄斧、短柄斧、越斧等。', null, 'prop1.jpg', null);
INSERT INTO `museum` VALUES ('6', '4', '崔莺莺', '王实甫《西厢记》里的崔莺莺是相国小姐，她深沉、含蓄，既有外在的凝重，又有内在的激情。封建家庭的教养，无法完全窒息她内心的青春情感。她不由自主的对张生（即张珙，字君瑞）一见倾心，月下隔墙吟诗，大胆地对张生吐露心声，陷入情网之中而不能自拔，饱尝着相思的痛苦。同时她也越来越不满于老夫人的约束，并迁怒于红娘的跟随。老夫人当众许婚，后来又出尔反尔，既赋于崔，张的婚事以外在的合理性，又赋于崔、张爱情以内在的合理性。正是这种内在和外在的合理性，成为莺莺敢于冲破老夫人的约束，决心对张君瑞以身相许的潜在动力。但是，冲破内在心理的樊笼毕竟比冲破外在人为的约束还在艰难，于是就有了莺莺的“闹简”和“赖简”，其中莺莺所表现的“假意儿”，不仅是为了试探红娘是否可靠，张生是否真心，更重要的是披露出崔莺莺战胜传统的教养、女性的禁忌所应有的反复和艰难。长亭送别时，莺莺既忧虑张生考试落第，婚事终成泡影，更担心张生考取后变心，另就高门，自己被弃置，承担着如此沉重的精神重压。|《西厢记》深刻地揭示了崔莺莺的恋爱心理，即想爱而不敢爱，不敢爱却不由得不爱；并且细致地展现了她内心的强烈要求逐步压倒、战胜外部的压抑、传统的禁锢和心理的樊笼的全过程。|老夫人毁约后，张生一撅不振，此时莺莺明明思念张生，让红娘去探望，但当见到红娘带回张生的简贴时，又“忽的波低垂了粉颈，改变了朱颜”，怒斥红娘说要告过夫人，打下你个小贱人下截来。”待红娘说要将简贴儿交与老夫人时，她又道:“我逗你耍来”，并急切地询问张生的情况。这种有辱于小姐身份的言行，是“欲”与“礼”的斗争。她在红娘面前遮掩，而内心又忍不住牵挂张生。|但她对张生的爱恋，一开始却是胆怯和动摇不定的，一方面她具有少女的情感和欲求；另一方面，她作为一个相国小姐又是在那样的母亲的管教下成长起来的，同时又接受过较多的封建道德教育，这就构成了她思想和行动上的矛盾。她回答张生的那首诗“兰闺久寂寞，无事度芳春：料得行吟者，应怜长叹人。”，表达了她不甘寂寞的苦闷心情，同时也流露了她对异性的渴望。在“听琴”的时候，她被张生琴中热切的呼唤深深地感动着，以致于泪水涟涟，但是她又没有勇气与张生见面。此时在她的心中，封建礼教的束缚和对张生的爱恋激烈地冲突着，最后爱情终于战胜了礼教。因此当她接到张生的情诗时，终于大着胆子写了一首题为《明月三五夜》的回诗，约定张生于十五日晚上相会。“待月西厢下，迎风户半开：拂墙花影动，凝是玉人来。”短短二十个字，标志着莺莺决然走上了叛逆的道路。', '相国小姐', 'team5.jpg', null);
INSERT INTO `museum` VALUES ('7', '5', '西厢记', '《崔莺莺待月西厢记》故事虽本唐代元稹《莺莺传》，实际却是脱胎于金代董解元的《西厢记诸宫调》。 [3]  王实甫曾任陕西县令、陕西行台监察御史。后来由于他不满当时官场的龌龊，愤而辞官，决心以写戏抒发心中之郁懑。于是他回到出生地中山府，开始了杂剧创作。金代的一位姓董的读书人，依据唐代元稹的传奇小说《莺莺传》改编成《诸宫调西厢记》，把原来故事中的主人公莺莺写成是博陵郡人。定州在隋代就称博陵郡，所以在博陵一带莺莺和张生的故事流传相当广泛。相传在定州崔沿士一带曾有过崔莺莺的墓冢。王实甫正是根据这一点，在中山府开始了他的杂剧《崔莺莺待月西厢记》的写作。 [5]  该剧大约写于元贞、大德年间（1295~1307年）。|张生在普救寺相遇相国小姐崔莺莺，一见钟情，而无计亲近。恰遇叛将孙飞虎率兵围寺，要强索莺莺为压寨夫人；张生在崔母亲口许婚下，依靠友人白马将军的帮助，解除了危难。不料崔母却食言赖婚，张生相思成疾。莺莺心爱张生而不愿正面表白；几经波折，在红娘的帮助下，莺莺终于至张生住处私会。崔母觉察迹象，拷问红娘，反被红娘几句话点中要害，勉强答应了婚事，却又以门第为由，令张生立即上京应试。十里长亭送别之后，张生到京考中状元；而郑恒借机编造谎言，说张生已在京另娶，老夫人又一次赖婚，要莺莺嫁于郑恒。后张生赶来，郑恒撞死，崔、张完婚。', null, 'reper1.png', null);
INSERT INTO `museum` VALUES ('8', '6', '阳春舞台', '绍兴女子文戏科班。1933年7月由嵊县杜联等人合股举办。班址在嵊县四明乡后城村(后移至上江村)。学艺期限定为三年半。招徒30余人，由钟加昌、金荣水为教戏师傅，开蒙戏为《仁义缘》、《红桃山》。六个月后，以尹树春(生)、吴梅珍(旦)、叶樟老(老生)、丁兆丰(丑)为“四柱头”，到浦口镇里东山区和绍兴水乡边演边学艺。后又教了《御碑亭》、《玉连环》、《四香缘》、《碧玉簪》、《二度梅》、《梁山伯与祝英台》等。在绍兴孙端镇时，适遇大王舞台、四季春科班同在一地演出，互相斗台竞艺，阳春舞台获得盛誉。1935年因股东不和，金荣水被迫离去，科班转卖给嵊县华堂镇王伯根，1936年下半年满师后散班。|', null, 'project1.jpg', null);
INSERT INTO `museum` VALUES ('9', '7', 'xxx', null, null, 'photo1.jpg', null);
INSERT INTO `museum` VALUES ('10', '6', 'xxx', 'xxx', null, 'project1.jpg', null);
INSERT INTO `museum` VALUES ('11', '6', 'xxx', 'xxx', null, 'project2.jpg', null);
INSERT INTO `museum` VALUES ('12', '6', 'xxx', 'xxxx', null, 'project3.jpg', null);
INSERT INTO `museum` VALUES ('13', '6', 'xxx', 'xxx', null, 'project4.jpg', null);
INSERT INTO `museum` VALUES ('14', '6', 'xxx', 'xxx', null, 'project5.jpg', null);
INSERT INTO `museum` VALUES ('15', '1', '单仰萍', '单仰萍，浙江桐庐（也有说法为建德）人，浙江省桐庐中学毕业。|1972年1月进入桐庐艺训班学戏，工旦角，后为桐庐越剧团主要演员。1984年7月，随桐庐越剧团首次到上海，主演《春江月》。1985年11月，随杭州市越剧二团再次到上海，主演《桐江雨》。后该两剧拍摄成戏曲艺术影片（片名为《绣花女传奇》和《桐江雨》），仍由她主演，表演上宗王（文娟）派。|1988年至1993年进入上海越剧院红楼团演戏。1998年再次进入红楼团。', '越剧一级演员', 'team5.jpg', null);
INSERT INTO `museum` VALUES ('16', '1', '单仰萍', '单仰萍，浙江桐庐（也有说法为建德）人，浙江省桐庐中学毕业。|1972年1月进入桐庐艺训班学戏，工旦角，后为桐庐越剧团主要演员。1984年7月，随桐庐越剧团首次到上海，主演《春江月》。1985年11月，随杭州市越剧二团再次到上海，主演《桐江雨》。后该两剧拍摄成戏曲艺术影片（片名为《绣花女传奇》和《桐江雨》），仍由她主演，表演上宗王（文娟）派。|1988年至1993年进入上海越剧院红楼团演戏。1998年再次进入红楼团。', '越剧一级演员', 'team5.jpg', null);
INSERT INTO `museum` VALUES ('17', '1', '单仰萍', '单仰萍，浙江桐庐（也有说法为建德）人，浙江省桐庐中学毕业。|1972年1月进入桐庐艺训班学戏，工旦角，后为桐庐越剧团主要演员。1984年7月，随桐庐越剧团首次到上海，主演《春江月》。1985年11月，随杭州市越剧二团再次到上海，主演《桐江雨》。后该两剧拍摄成戏曲艺术影片（片名为《绣花女传奇》和《桐江雨》），仍由她主演，表演上宗王（文娟）派。|1988年至1993年进入上海越剧院红楼团演戏。1998年再次进入红楼团。', '越剧一级演员', 'team5.jpg', null);

-- ----------------------------
-- Table structure for `museum_class`
-- ----------------------------
DROP TABLE IF EXISTS `museum_class`;
CREATE TABLE `museum_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kind` int(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of museum_class
-- ----------------------------
INSERT INTO `museum_class` VALUES ('1', '1', '越剧名家', 'yueju_museum.html');
INSERT INTO `museum_class` VALUES ('2', '2', '戏服展示', 'yueju_museum_clothing.html');
INSERT INTO `museum_class` VALUES ('3', '3', '道具百科', 'yueju_museum_prop.html');
INSERT INTO `museum_class` VALUES ('4', '4', '经典人物', 'yueju_museum_characters.html');
INSERT INTO `museum_class` VALUES ('5', '5', '经典剧目', 'yueju_museum_repertoire.html');
INSERT INTO `museum_class` VALUES ('6', '6', '越剧艺术团', 'yueju_museum_troupe.html');
INSERT INTO `museum_class` VALUES ('7', '7', '剧照', 'yueju_museum_photo.html');

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `publish_time` varchar(255) DEFAULT NULL,
  `content` text,
  `picture` varchar(255) DEFAULT NULL,
  `is_hot` int(11) DEFAULT NULL,
  `is_publish` int(11) DEFAULT NULL,
  `click_num` int(11) DEFAULT NULL,
  `exam_status` int(11) DEFAULT NULL,
  `expansion1` varchar(20) DEFAULT NULL,
  `expansion2` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', '第十七届越剧大展演昨晚闭幕 越剧“金兰”最佳演员诞生', 'admin', '2011-01-02', '7月7日晚上，为期一个月的“同唱一台戏”2019(中国·绍兴)第十七届越剧大展演落下帷幕，5位越剧“金兰”最佳演员随之诞生。|据了解，今年的越剧大展演为期32天，全国11个剧院联动，进行了43场演出和14场网络直播，共有5万人次走进剧院，近10万人观看了网上直播，70多万人参与了网络票选。“今年是我们首次尝试多城联动的模式，将活动从以前相对单一的城市，辐射到周边更广泛的地区和剧院，大幅提升了大展演的规模和影响力，也为更多的观众带去便利。”绍兴越剧艺术发展有限公司相关负责人介绍。|当晚既是本届大展演的闭幕式，也是越剧“金兰”最佳演员竞演专场。记者在现场看到，本次竞演以“青春的舞台越剧的未来”为主题，13个剧团推选的28名青年演员经过初赛时专业评委的打分和网络人气的综合考量，10位演员脱颖而出，参与到当晚的越剧“金兰”最佳演员的角逐中。|选手们依次上场，经过一番较量，最终得分前5位的选手获得了越剧“金兰”最佳演员。得分最高的选手是来自南京市越剧院的李晓旭，她说这是一次含金量非常高的比赛，他们团里从上到下都非常重视，反复练习彩排，只为把最好的一面展示出来。', 'assets/images/blog/bl2.jpg', null, '1', '1', null, null, null);
INSERT INTO `news` VALUES ('2', '“越美中华·越剧青年演员大汇演”拉开帷幕', 'admin', '2012-02-02', '著名越剧表演艺术家沈月凤(中)亮相“永联杯·越美中华·越剧青年演员大汇演”新闻发布会。|中新网上海6月28日电(王笈) “永联杯·越美中华·越剧青年演员大汇演”新闻发布会28日在海上梨园举行。越剧名家孟莉英、张伟忠、金静、徐铭、陈丽宇以及昆曲表演艺术家汪世瑜代表评委接过聘书，24家参演团体的各行当青年演员代表进行了宣誓仪式，汇演活动主题曲《追梦·青春》同时首发。|“越美中华·越剧青年演员大汇演”继承了越剧大奖赛的优良传统，旨在展现当下最年轻一代越剧青年的整体风采。活动共分为越秀组(25周岁—35周岁)、新蕾组(25周岁以下)两组进行，通过首轮汇演、晋级竞演、两轮复活、终级竞演等展示环节，最终将诞生金奖选手以及单项荣誉若干名。|据统计，此次汇演共有来自24家专业团体、艺术学校的近200名青年演员参加，其中越秀组80人、新蕾组116人，参加演员及参与院团均创下历史之最。除女子越剧特色外，汇演也为越剧青年男演员提供了展示平台，来自上海越剧院、浙江越剧团、绍兴小百花越剧团等多家单位的15名越剧男演员亦参与其中。|与往届大奖赛不同的是，此次汇演在晋级展示阶段将采用团队对抗的方式一较风采；活动还将在戏曲界首次采用“台网联动”传播，《东方大剧院》将现场转播活动全程，包括首轮汇演、晋级竞演、复活对决和终级竞演，两场复活展示则将通过网络进行投票。|永联杯·越美中华·越剧青年演员大汇演”由上海市戏剧家协会、浙江省戏剧家协会、江苏省戏剧家协会、福建省戏剧家协会担任指导单位，中国广播电视网络有限公司、东方卫视中心公益媒体中心、国广东方网络(北京)有限公司共同主办。', 'assets/images/blog/bl2.jpg', null, '1', '1', null, null, null);
INSERT INTO `news` VALUES ('3', 'Seeing The Big Picture Of Information And Information Management', 'admin', '2013-11-21', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis.|qqqqqqqqqqqqqqq', 'assets/images/blog/bl2.jpg', null, '1', '1', null, null, null);
INSERT INTO `news` VALUES ('4', 'Seeing The Big Picture Of Information And Information Management', 'admin', '1999-12-12', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis.|qqqqqqqqqqqqqqq', 'assets/images/blog/bl2.jpg', null, '1', '1', null, null, null);
INSERT INTO `news` VALUES ('5', 'Seeing The Big Picture Of Information And Information Management', 'admin', '1998-12-12', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis.|qqqqqqqqqqqqqqq', 'assets/images/blog/bl2.jpg', null, '1', '1', null, null, null);
INSERT INTO `news` VALUES ('6', 'Seeing The Big Picture Of Information And Information Management', 'admin', '1997-12-12', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis.|qqqqqqqqqqqqqqq', 'assets/images/blog/bl2.jpg', null, '1', '1', null, null, null);
INSERT INTO `news` VALUES ('7', 'Seeing The Big Picture Of Information And Information Management', 'admin', '1996-12-12', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis.|qqqqqqqqqqqqqqq', 'assets/images/blog/bl2.jpg', null, '1', '1', null, null, null);
INSERT INTO `news` VALUES ('8', '8', null, null, null, null, null, '1', '1', null, null, null);

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `pid` int(22) NOT NULL,
  `premission` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for `review`
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `id` int(22) NOT NULL,
  `vid` int(22) DEFAULT NULL,
  `uid` int(22) DEFAULT NULL,
  `content` text,
  `picture` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of review
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rid` int(22) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(22) NOT NULL,
  `rid` int(22) NOT NULL,
  `pid` int(22) NOT NULL,
  `status` int(22) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(8) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `user_real_name` varchar(20) DEFAULT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `last_login_ip` datetime DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', '123', '123', '13565675637', '小明', '明明', null, null, '111111@qq.com');
INSERT INTO `userinfo` VALUES ('2', '1', '1', '18958956789', '小陈', '陈陈', null, null, '222222@qq.com');

-- ----------------------------
-- Table structure for `video`
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `play_num` int(20) DEFAULT NULL,
  `collect_num` int(20) DEFAULT NULL,
  `publish_time` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `review_id` int(22) DEFAULT NULL,
  `kind` int(22) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video
-- ----------------------------

-- ----------------------------
-- Table structure for `video_class`
-- ----------------------------
DROP TABLE IF EXISTS `video_class`;
CREATE TABLE `video_class` (
  `id` varchar(10) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video_class
-- ----------------------------

-- ----------------------------
-- Table structure for `video_collect`
-- ----------------------------
DROP TABLE IF EXISTS `video_collect`;
CREATE TABLE `video_collect` (
  `id` int(22) NOT NULL AUTO_INCREMENT,
  `uid` int(22) DEFAULT NULL,
  `vid` int(22) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video_collect
-- ----------------------------
