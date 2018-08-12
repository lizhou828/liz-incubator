package com.liz.multipleThread.thread;

import com.liz.multipleThread.utils.FileUtils;
import com.liz.multipleThread.utils.StringUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.liz.multipleThread.thread.MultiThreadDownloadTest.downloadPath;

/**
 * Created by lizhou on 2018年08月11日 15时38分
 */
public class MultiThreadDownloadTest {


    protected static final String downloadPath = "C:\\Users\\Administrator\\Desktop\\test";

    private static CountDownLatch sCountDownLatch = null;

    private static  int THREAD_NUMBER = 0;

    public static void main(String[] args) throws InterruptedException {
        File file = new File(downloadPath);
        if(!file.exists()){
            System.err.println("存放文件的目录不存在！");
            return;
        }
        System.out.println("单线程文件下载============================");
        List<String> fileUrlList = new ArrayList<String>();
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=294db374d462853592e0d229a0ee76f2/e732c895d143ad4b630e8f4683025aafa40f0611.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=294db374d462853592e0d229a0ee76f2/e732c895d143ad4b630e8f4683025aafa40f0611.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=941c6a9596dda144da096cba82b6d009/e889d43f8794a4c2e5d529ad0ff41bd5ac6e3947.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=750661a0fcfaaf5184e381b7bc5594ed/75fafbedab64034fc3ed0b80aec379310a551d11.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=114c0f68b58f8c54e3d3c5270a282dee/3d4e78f0f736afc3c72cf6e3b219ebc4b7451211.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=3b5751825882b2b7a79f39cc01accb0a/9ac37d1ed21b0ef481c651d8dcc451da81cb3e0f.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=26c16593bd315c6043956be7bdb0cbe6/894443a98226cffcd8287634b8014a90f603ea3c.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=8905fff979f0f736d8fe4c093a54b382/08d2d539b6003af318e615e6342ac65c1138b6dd.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=c6335d3d86d6277fe912323018391f63/9dcd7cd98d1001e97833dd89b90e7bec54e7972e.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=0d3b26024bed2e73fce98624b700a16d/0faccbef76094b3697eed26ba2cc7cd98d109d3d.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=a6b7ab9a10dfa9ecfd2e561f52d1f754/48c7a7efce1b9d16a99e53e7f2deb48f8d5464d8.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=4fb535a17e3e6709be0045f70bc69fb8/50071d950a7b020893c7f66763d9f2d3572cc828.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=e87250192fdda3cc0be4b82831e83905/07dab6fd5266d016aa6057ae962bd40735fa3538.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=ac526d39a1ec08fa260013af69ef3d4d/8a8e8c5494eef01f6178d143e1fe9925bd317dcd.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=808342bf6a63f6241c5d390bb745eb32/f2be6c81800a19d8cea24d8332fa828ba71e4690.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=7bbea1d635a85edffa8cfe2b795509d8/bc27cffc1e178a827e8eb726f703738da877e88c.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=1e9533ad9c16fdfad86cc6e6848e8cea/9a0e4bfbfbedab64ba358546f636afc378311ef6.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=3bb59f66f603918fd7d13dc2613c264b/9150f3deb48f8c54cc7c0da93b292df5e1fe7f8e.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=744160a0fcfaaf5184e381b7bc5594ed/75fafbedab64034fc2aa0a80aec379310b551dd6.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=37854f4d42166d223877159c76220945/82305c6034a85edfefcf36a548540923dc5475f2.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=61592a7c7acb0a4685228b315b62f63e/ef08b3de9c82d158a1159137810a19d8bd3e42a6.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=85db4de7f91986184147ef8c7aec2e69/6783b2b7d0a20cf4076d365977094b36adaf99bc.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=9a886c9596dda144da096cba82b6d009/e889d43f8794a4c2eb412fad0ff41bd5ac6e39d3.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=84e0f495dc54564ee565e43183df9cde/c802738da97739127eaf4de7f9198618377ae2a9.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=a90dc4b7203fb80e0cd161df06d32ffb/a92ad40735fae6cdd36d63e70eb30f2443a70f58.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=0094db034bed2e73fce98624b703a16d/0faccbef76094b369a412f6aa2cc7cd98c109d62.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=21539892bd315c6043956be7bdb0cbe6/894443a98226cffcdfba8b35b8014a90f703eaa2.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=13f2ccac9c16fdfad86cc6e6848e8cea/9a0e4bfbfbedab64b7527a47f636afc379311e11.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=37639659f11f3a295ac8d5c6a924bce3/91c279310a55b31950f3b5f242a98226cffc172b.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=09f793f2d788d43ff0a991fa4d1cd2aa/6f3c269759ee3d6da00fb34c42166d224e4ade69.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=583cbe865d6034a829e2b889fb1249d9/7da88226cffc1e174b9bbbb64b90f603738de916.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=cce587af377adab43dd01b4bbbd6b36b/eea30cf431adcbef42f54a81adaf2edda2cc9f70.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=fc8fabb64d086e066aa83f4332097b5a/08d02f2eb9389b500bd4d7d58435e5dde7116e0a.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=bad0967c38dbb6fd255be52e3925aba6/ae539822720e0cf33cc06c7c0b46f21fbe09aa07.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=4c219282e4dde711e7d243fe97eecef4/ef42ad4bd11373f01b414d18a50f4bfbfbed043f.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=5c33e5a8bf096b6381195e583c328733/ef59ccbf6c81800a4fadab89b03533fa838b47e9.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=694ea4699d82d158bb8259b9b00b19d5/8e50f8198618367a62f35d5a2f738bd4b21ce5c4.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=75b71de2b219ebc4c0787691b227cf79/d751352ac65c10385fc5ec45b3119313b17e89fa.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=e85eb058cf1b9d168ac79a69c3dfb4eb/64aea40f4bfbfbed35fc14f879f0f736aec31f94.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=fb0c5d5a2f738bd4c421b239918a876c/f5ee76094b36acaf0f65b47b7dd98d1000e99cb4.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b6723688b90e7bec23da03e91f2fb9fa/ea0635fae6cd7b89112218040e2442a7d8330eef.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=d4b5a14a5366d0167e199e20a72ad498/4c0f0cf3d7ca7bcbe728e5a8bf096b63f724a8e3.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b84964f242a98226b8c12b2fba83b97a/2e395343fbf2b211c09e63c9cb8065380dd78e82.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=04c3e9443b87e9504217f3642039531b/05c69f3df8dcd10008621ea6738b4710b8122fb8.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=ad53875037d12f2ece05ae687fc3d5ff/45889e510fb30f2494180a84c995d143ac4b03bc.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=5b9860aeeac4b7453494b71efffd1e78/0b2bc65c10385343aa3f61a69213b07ecb808842.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=35882481aec379317d688621dbc5b784/88013af33a87e950785215eb11385343faf2b4f5.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=2ad04ea1fcfaaf5184e381b7bc5594ed/75fafbedab64034f9c3b2481aec379310b551d40.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=814c097350da81cb4ee683c56267d0a4/782209f7905298225e2cd844d6ca7bcb0a46d41f.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=d60df942e1fe9925cb0c695804a95ee4/8d18ebc4b74543a96e021b4b1f178a82b9011419.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b9cb63f242a98226b8c12b2fba83b97a/2e395343fbf2b211c11c64c9cb8065380cd78e0c.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=6c1eaf5b55e736d158138c00ab514ffc/d8cc7b899e510fb3db349610d833c895d1430c0d.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=a18570757c1ed21b79c92eed9d6fddae/6bfab2fb43166d22695bf413472309f79052d20e.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=34e22381aec379317d688621dbc5b784/88013af33a87e950793812eb11385343fbf2b40f.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=33239710d833c895a67e9873e1127397/244d510fd9f9d72a5c5ef09ad52a2834349bbb04.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=131d23b4728da9774e2f86238050f872/32d6912397dda144f4b98c35b3b7d0a20df48682.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=99bb027d7acb0a4685228b315b62f63e/ef08b3de9c82d15859f7b936810a19d8bd3e42c5.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=0298337a7a899e51788e3a1c72a6d990/c8256b600c338744dc9acffb500fd9f9d62aa0df.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=5ce70dcb8ad4b31cf03c94b3b7d7276f/48084b36acaf2eddb5c65f618c1001e939019307.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=5d5b0ccb8ad4b31cf03c94b3b7d7276f/48084b36acaf2eddb47a5e618c1001e9380193ab.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=73b8ff7c50da81cb4ee683c56264d0a4/782209f790529822acd82e4bd6ca7bcb0b46d454.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=fdcdb5b2314e251fe2f7e4f09784c9c2/16391f30e924b89915f86eb06f061d950b7bf677.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=6a438de9f2deb48ffb69a1d6c01e3aef/9565034f78f0f736387a5b890b55b319eac413b6.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=862cd58eaec379317d688621dbc6b784/88013af33a87e950cbf6e4e411385343faf2b452.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b47767118326cffc692abfba89004a7d/6d42fbf2b2119313b34cee3864380cd791238d2f.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=e98093fd42a98226b8c12b2fba83b97a/2e395343fbf2b211915794c6cb8065380cd78e39.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b8640487b90e7bec23da03e91f2fb9fa/ea0635fae6cd7b891f342a0b0e2442a7d8330eda.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=4031f330d53f8794d3ff4826e21a0ead/189659ee3d6d55fb608f66ae6c224f4a21a4ddea.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b9458a86b03533faf5b6932698d2fdca/b5d5b31c8701a18b274b11c79f2f07082938fe93.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=294db374d462853592e0d229a0ee76f2/e732c895d143ad4b630e8f4683025aafa40f0611.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=294db374d462853592e0d229a0ee76f2/e732c895d143ad4b630e8f4683025aafa40f0611.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=941c6a9596dda144da096cba82b6d009/e889d43f8794a4c2e5d529ad0ff41bd5ac6e3947.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=750661a0fcfaaf5184e381b7bc5594ed/75fafbedab64034fc3ed0b80aec379310a551d11.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=114c0f68b58f8c54e3d3c5270a282dee/3d4e78f0f736afc3c72cf6e3b219ebc4b7451211.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=3b5751825882b2b7a79f39cc01accb0a/9ac37d1ed21b0ef481c651d8dcc451da81cb3e0f.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=26c16593bd315c6043956be7bdb0cbe6/894443a98226cffcd8287634b8014a90f603ea3c.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=8905fff979f0f736d8fe4c093a54b382/08d2d539b6003af318e615e6342ac65c1138b6dd.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=c6335d3d86d6277fe912323018391f63/9dcd7cd98d1001e97833dd89b90e7bec54e7972e.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=0d3b26024bed2e73fce98624b700a16d/0faccbef76094b3697eed26ba2cc7cd98d109d3d.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=a6b7ab9a10dfa9ecfd2e561f52d1f754/48c7a7efce1b9d16a99e53e7f2deb48f8d5464d8.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=4fb535a17e3e6709be0045f70bc69fb8/50071d950a7b020893c7f66763d9f2d3572cc828.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=e87250192fdda3cc0be4b82831e83905/07dab6fd5266d016aa6057ae962bd40735fa3538.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=ac526d39a1ec08fa260013af69ef3d4d/8a8e8c5494eef01f6178d143e1fe9925bd317dcd.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=808342bf6a63f6241c5d390bb745eb32/f2be6c81800a19d8cea24d8332fa828ba71e4690.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=7bbea1d635a85edffa8cfe2b795509d8/bc27cffc1e178a827e8eb726f703738da877e88c.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=1e9533ad9c16fdfad86cc6e6848e8cea/9a0e4bfbfbedab64ba358546f636afc378311ef6.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=3bb59f66f603918fd7d13dc2613c264b/9150f3deb48f8c54cc7c0da93b292df5e1fe7f8e.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=744160a0fcfaaf5184e381b7bc5594ed/75fafbedab64034fc2aa0a80aec379310b551dd6.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=37854f4d42166d223877159c76220945/82305c6034a85edfefcf36a548540923dc5475f2.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=61592a7c7acb0a4685228b315b62f63e/ef08b3de9c82d158a1159137810a19d8bd3e42a6.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=85db4de7f91986184147ef8c7aec2e69/6783b2b7d0a20cf4076d365977094b36adaf99bc.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=9a886c9596dda144da096cba82b6d009/e889d43f8794a4c2eb412fad0ff41bd5ac6e39d3.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=84e0f495dc54564ee565e43183df9cde/c802738da97739127eaf4de7f9198618377ae2a9.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=a90dc4b7203fb80e0cd161df06d32ffb/a92ad40735fae6cdd36d63e70eb30f2443a70f58.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=0094db034bed2e73fce98624b703a16d/0faccbef76094b369a412f6aa2cc7cd98c109d62.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=21539892bd315c6043956be7bdb0cbe6/894443a98226cffcdfba8b35b8014a90f703eaa2.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=13f2ccac9c16fdfad86cc6e6848e8cea/9a0e4bfbfbedab64b7527a47f636afc379311e11.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=37639659f11f3a295ac8d5c6a924bce3/91c279310a55b31950f3b5f242a98226cffc172b.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=09f793f2d788d43ff0a991fa4d1cd2aa/6f3c269759ee3d6da00fb34c42166d224e4ade69.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=583cbe865d6034a829e2b889fb1249d9/7da88226cffc1e174b9bbbb64b90f603738de916.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=cce587af377adab43dd01b4bbbd6b36b/eea30cf431adcbef42f54a81adaf2edda2cc9f70.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=fc8fabb64d086e066aa83f4332097b5a/08d02f2eb9389b500bd4d7d58435e5dde7116e0a.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=bad0967c38dbb6fd255be52e3925aba6/ae539822720e0cf33cc06c7c0b46f21fbe09aa07.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=4c219282e4dde711e7d243fe97eecef4/ef42ad4bd11373f01b414d18a50f4bfbfbed043f.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=5c33e5a8bf096b6381195e583c328733/ef59ccbf6c81800a4fadab89b03533fa838b47e9.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=694ea4699d82d158bb8259b9b00b19d5/8e50f8198618367a62f35d5a2f738bd4b21ce5c4.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=75b71de2b219ebc4c0787691b227cf79/d751352ac65c10385fc5ec45b3119313b17e89fa.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=e85eb058cf1b9d168ac79a69c3dfb4eb/64aea40f4bfbfbed35fc14f879f0f736aec31f94.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=fb0c5d5a2f738bd4c421b239918a876c/f5ee76094b36acaf0f65b47b7dd98d1000e99cb4.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b6723688b90e7bec23da03e91f2fb9fa/ea0635fae6cd7b89112218040e2442a7d8330eef.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=d4b5a14a5366d0167e199e20a72ad498/4c0f0cf3d7ca7bcbe728e5a8bf096b63f724a8e3.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b84964f242a98226b8c12b2fba83b97a/2e395343fbf2b211c09e63c9cb8065380dd78e82.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=04c3e9443b87e9504217f3642039531b/05c69f3df8dcd10008621ea6738b4710b8122fb8.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=ad53875037d12f2ece05ae687fc3d5ff/45889e510fb30f2494180a84c995d143ac4b03bc.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=5b9860aeeac4b7453494b71efffd1e78/0b2bc65c10385343aa3f61a69213b07ecb808842.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=35882481aec379317d688621dbc5b784/88013af33a87e950785215eb11385343faf2b4f5.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=2ad04ea1fcfaaf5184e381b7bc5594ed/75fafbedab64034f9c3b2481aec379310b551d40.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=814c097350da81cb4ee683c56267d0a4/782209f7905298225e2cd844d6ca7bcb0a46d41f.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=d60df942e1fe9925cb0c695804a95ee4/8d18ebc4b74543a96e021b4b1f178a82b9011419.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b9cb63f242a98226b8c12b2fba83b97a/2e395343fbf2b211c11c64c9cb8065380cd78e0c.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=6c1eaf5b55e736d158138c00ab514ffc/d8cc7b899e510fb3db349610d833c895d1430c0d.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=a18570757c1ed21b79c92eed9d6fddae/6bfab2fb43166d22695bf413472309f79052d20e.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=34e22381aec379317d688621dbc5b784/88013af33a87e950793812eb11385343fbf2b40f.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=33239710d833c895a67e9873e1127397/244d510fd9f9d72a5c5ef09ad52a2834349bbb04.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=131d23b4728da9774e2f86238050f872/32d6912397dda144f4b98c35b3b7d0a20df48682.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=99bb027d7acb0a4685228b315b62f63e/ef08b3de9c82d15859f7b936810a19d8bd3e42c5.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=0298337a7a899e51788e3a1c72a6d990/c8256b600c338744dc9acffb500fd9f9d62aa0df.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=5ce70dcb8ad4b31cf03c94b3b7d7276f/48084b36acaf2eddb5c65f618c1001e939019307.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=5d5b0ccb8ad4b31cf03c94b3b7d7276f/48084b36acaf2eddb47a5e618c1001e9380193ab.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=73b8ff7c50da81cb4ee683c56264d0a4/782209f790529822acd82e4bd6ca7bcb0b46d454.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=fdcdb5b2314e251fe2f7e4f09784c9c2/16391f30e924b89915f86eb06f061d950b7bf677.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=6a438de9f2deb48ffb69a1d6c01e3aef/9565034f78f0f736387a5b890b55b319eac413b6.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=862cd58eaec379317d688621dbc6b784/88013af33a87e950cbf6e4e411385343faf2b452.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b47767118326cffc692abfba89004a7d/6d42fbf2b2119313b34cee3864380cd791238d2f.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=e98093fd42a98226b8c12b2fba83b97a/2e395343fbf2b211915794c6cb8065380cd78e39.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b8640487b90e7bec23da03e91f2fb9fa/ea0635fae6cd7b891f342a0b0e2442a7d8330eda.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=4031f330d53f8794d3ff4826e21a0ead/189659ee3d6d55fb608f66ae6c224f4a21a4ddea.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b9458a86b03533faf5b6932698d2fdca/b5d5b31c8701a18b274b11c79f2f07082938fe93.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=294db374d462853592e0d229a0ee76f2/e732c895d143ad4b630e8f4683025aafa40f0611.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=294db374d462853592e0d229a0ee76f2/e732c895d143ad4b630e8f4683025aafa40f0611.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=941c6a9596dda144da096cba82b6d009/e889d43f8794a4c2e5d529ad0ff41bd5ac6e3947.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=750661a0fcfaaf5184e381b7bc5594ed/75fafbedab64034fc3ed0b80aec379310a551d11.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=114c0f68b58f8c54e3d3c5270a282dee/3d4e78f0f736afc3c72cf6e3b219ebc4b7451211.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=3b5751825882b2b7a79f39cc01accb0a/9ac37d1ed21b0ef481c651d8dcc451da81cb3e0f.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=26c16593bd315c6043956be7bdb0cbe6/894443a98226cffcd8287634b8014a90f603ea3c.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=8905fff979f0f736d8fe4c093a54b382/08d2d539b6003af318e615e6342ac65c1138b6dd.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=c6335d3d86d6277fe912323018391f63/9dcd7cd98d1001e97833dd89b90e7bec54e7972e.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=0d3b26024bed2e73fce98624b700a16d/0faccbef76094b3697eed26ba2cc7cd98d109d3d.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=a6b7ab9a10dfa9ecfd2e561f52d1f754/48c7a7efce1b9d16a99e53e7f2deb48f8d5464d8.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=4fb535a17e3e6709be0045f70bc69fb8/50071d950a7b020893c7f66763d9f2d3572cc828.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=e87250192fdda3cc0be4b82831e83905/07dab6fd5266d016aa6057ae962bd40735fa3538.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=ac526d39a1ec08fa260013af69ef3d4d/8a8e8c5494eef01f6178d143e1fe9925bd317dcd.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=808342bf6a63f6241c5d390bb745eb32/f2be6c81800a19d8cea24d8332fa828ba71e4690.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=7bbea1d635a85edffa8cfe2b795509d8/bc27cffc1e178a827e8eb726f703738da877e88c.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=1e9533ad9c16fdfad86cc6e6848e8cea/9a0e4bfbfbedab64ba358546f636afc378311ef6.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=3bb59f66f603918fd7d13dc2613c264b/9150f3deb48f8c54cc7c0da93b292df5e1fe7f8e.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=744160a0fcfaaf5184e381b7bc5594ed/75fafbedab64034fc2aa0a80aec379310b551dd6.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=37854f4d42166d223877159c76220945/82305c6034a85edfefcf36a548540923dc5475f2.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=61592a7c7acb0a4685228b315b62f63e/ef08b3de9c82d158a1159137810a19d8bd3e42a6.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=85db4de7f91986184147ef8c7aec2e69/6783b2b7d0a20cf4076d365977094b36adaf99bc.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=9a886c9596dda144da096cba82b6d009/e889d43f8794a4c2eb412fad0ff41bd5ac6e39d3.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=84e0f495dc54564ee565e43183df9cde/c802738da97739127eaf4de7f9198618377ae2a9.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=a90dc4b7203fb80e0cd161df06d32ffb/a92ad40735fae6cdd36d63e70eb30f2443a70f58.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=0094db034bed2e73fce98624b703a16d/0faccbef76094b369a412f6aa2cc7cd98c109d62.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=21539892bd315c6043956be7bdb0cbe6/894443a98226cffcdfba8b35b8014a90f703eaa2.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=13f2ccac9c16fdfad86cc6e6848e8cea/9a0e4bfbfbedab64b7527a47f636afc379311e11.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=37639659f11f3a295ac8d5c6a924bce3/91c279310a55b31950f3b5f242a98226cffc172b.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=09f793f2d788d43ff0a991fa4d1cd2aa/6f3c269759ee3d6da00fb34c42166d224e4ade69.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=583cbe865d6034a829e2b889fb1249d9/7da88226cffc1e174b9bbbb64b90f603738de916.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=cce587af377adab43dd01b4bbbd6b36b/eea30cf431adcbef42f54a81adaf2edda2cc9f70.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=fc8fabb64d086e066aa83f4332097b5a/08d02f2eb9389b500bd4d7d58435e5dde7116e0a.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=bad0967c38dbb6fd255be52e3925aba6/ae539822720e0cf33cc06c7c0b46f21fbe09aa07.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=4c219282e4dde711e7d243fe97eecef4/ef42ad4bd11373f01b414d18a50f4bfbfbed043f.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=5c33e5a8bf096b6381195e583c328733/ef59ccbf6c81800a4fadab89b03533fa838b47e9.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=694ea4699d82d158bb8259b9b00b19d5/8e50f8198618367a62f35d5a2f738bd4b21ce5c4.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=75b71de2b219ebc4c0787691b227cf79/d751352ac65c10385fc5ec45b3119313b17e89fa.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=e85eb058cf1b9d168ac79a69c3dfb4eb/64aea40f4bfbfbed35fc14f879f0f736aec31f94.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=fb0c5d5a2f738bd4c421b239918a876c/f5ee76094b36acaf0f65b47b7dd98d1000e99cb4.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b6723688b90e7bec23da03e91f2fb9fa/ea0635fae6cd7b89112218040e2442a7d8330eef.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=d4b5a14a5366d0167e199e20a72ad498/4c0f0cf3d7ca7bcbe728e5a8bf096b63f724a8e3.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b84964f242a98226b8c12b2fba83b97a/2e395343fbf2b211c09e63c9cb8065380dd78e82.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=04c3e9443b87e9504217f3642039531b/05c69f3df8dcd10008621ea6738b4710b8122fb8.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=ad53875037d12f2ece05ae687fc3d5ff/45889e510fb30f2494180a84c995d143ac4b03bc.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=5b9860aeeac4b7453494b71efffd1e78/0b2bc65c10385343aa3f61a69213b07ecb808842.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=35882481aec379317d688621dbc5b784/88013af33a87e950785215eb11385343faf2b4f5.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=2ad04ea1fcfaaf5184e381b7bc5594ed/75fafbedab64034f9c3b2481aec379310b551d40.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=814c097350da81cb4ee683c56267d0a4/782209f7905298225e2cd844d6ca7bcb0a46d41f.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=d60df942e1fe9925cb0c695804a95ee4/8d18ebc4b74543a96e021b4b1f178a82b9011419.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b9cb63f242a98226b8c12b2fba83b97a/2e395343fbf2b211c11c64c9cb8065380cd78e0c.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=6c1eaf5b55e736d158138c00ab514ffc/d8cc7b899e510fb3db349610d833c895d1430c0d.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=a18570757c1ed21b79c92eed9d6fddae/6bfab2fb43166d22695bf413472309f79052d20e.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=34e22381aec379317d688621dbc5b784/88013af33a87e950793812eb11385343fbf2b40f.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=33239710d833c895a67e9873e1127397/244d510fd9f9d72a5c5ef09ad52a2834349bbb04.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=131d23b4728da9774e2f86238050f872/32d6912397dda144f4b98c35b3b7d0a20df48682.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=99bb027d7acb0a4685228b315b62f63e/ef08b3de9c82d15859f7b936810a19d8bd3e42c5.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=0298337a7a899e51788e3a1c72a6d990/c8256b600c338744dc9acffb500fd9f9d62aa0df.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=5ce70dcb8ad4b31cf03c94b3b7d7276f/48084b36acaf2eddb5c65f618c1001e939019307.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=5d5b0ccb8ad4b31cf03c94b3b7d7276f/48084b36acaf2eddb47a5e618c1001e9380193ab.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=73b8ff7c50da81cb4ee683c56264d0a4/782209f790529822acd82e4bd6ca7bcb0b46d454.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=fdcdb5b2314e251fe2f7e4f09784c9c2/16391f30e924b89915f86eb06f061d950b7bf677.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=6a438de9f2deb48ffb69a1d6c01e3aef/9565034f78f0f736387a5b890b55b319eac413b6.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=862cd58eaec379317d688621dbc6b784/88013af33a87e950cbf6e4e411385343faf2b452.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b47767118326cffc692abfba89004a7d/6d42fbf2b2119313b34cee3864380cd791238d2f.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=e98093fd42a98226b8c12b2fba83b97a/2e395343fbf2b211915794c6cb8065380cd78e39.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b8640487b90e7bec23da03e91f2fb9fa/ea0635fae6cd7b891f342a0b0e2442a7d8330eda.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=4031f330d53f8794d3ff4826e21a0ead/189659ee3d6d55fb608f66ae6c224f4a21a4ddea.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b9458a86b03533faf5b6932698d2fdca/b5d5b31c8701a18b274b11c79f2f07082938fe93.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=294db374d462853592e0d229a0ee76f2/e732c895d143ad4b630e8f4683025aafa40f0611.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=294db374d462853592e0d229a0ee76f2/e732c895d143ad4b630e8f4683025aafa40f0611.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=941c6a9596dda144da096cba82b6d009/e889d43f8794a4c2e5d529ad0ff41bd5ac6e3947.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=750661a0fcfaaf5184e381b7bc5594ed/75fafbedab64034fc3ed0b80aec379310a551d11.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=114c0f68b58f8c54e3d3c5270a282dee/3d4e78f0f736afc3c72cf6e3b219ebc4b7451211.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=3b5751825882b2b7a79f39cc01accb0a/9ac37d1ed21b0ef481c651d8dcc451da81cb3e0f.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=26c16593bd315c6043956be7bdb0cbe6/894443a98226cffcd8287634b8014a90f603ea3c.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=8905fff979f0f736d8fe4c093a54b382/08d2d539b6003af318e615e6342ac65c1138b6dd.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=c6335d3d86d6277fe912323018391f63/9dcd7cd98d1001e97833dd89b90e7bec54e7972e.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=0d3b26024bed2e73fce98624b700a16d/0faccbef76094b3697eed26ba2cc7cd98d109d3d.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=a6b7ab9a10dfa9ecfd2e561f52d1f754/48c7a7efce1b9d16a99e53e7f2deb48f8d5464d8.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=4fb535a17e3e6709be0045f70bc69fb8/50071d950a7b020893c7f66763d9f2d3572cc828.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=e87250192fdda3cc0be4b82831e83905/07dab6fd5266d016aa6057ae962bd40735fa3538.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=ac526d39a1ec08fa260013af69ef3d4d/8a8e8c5494eef01f6178d143e1fe9925bd317dcd.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=808342bf6a63f6241c5d390bb745eb32/f2be6c81800a19d8cea24d8332fa828ba71e4690.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=7bbea1d635a85edffa8cfe2b795509d8/bc27cffc1e178a827e8eb726f703738da877e88c.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=1e9533ad9c16fdfad86cc6e6848e8cea/9a0e4bfbfbedab64ba358546f636afc378311ef6.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=3bb59f66f603918fd7d13dc2613c264b/9150f3deb48f8c54cc7c0da93b292df5e1fe7f8e.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=744160a0fcfaaf5184e381b7bc5594ed/75fafbedab64034fc2aa0a80aec379310b551dd6.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=37854f4d42166d223877159c76220945/82305c6034a85edfefcf36a548540923dc5475f2.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=61592a7c7acb0a4685228b315b62f63e/ef08b3de9c82d158a1159137810a19d8bd3e42a6.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=85db4de7f91986184147ef8c7aec2e69/6783b2b7d0a20cf4076d365977094b36adaf99bc.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=9a886c9596dda144da096cba82b6d009/e889d43f8794a4c2eb412fad0ff41bd5ac6e39d3.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=84e0f495dc54564ee565e43183df9cde/c802738da97739127eaf4de7f9198618377ae2a9.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=a90dc4b7203fb80e0cd161df06d32ffb/a92ad40735fae6cdd36d63e70eb30f2443a70f58.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=0094db034bed2e73fce98624b703a16d/0faccbef76094b369a412f6aa2cc7cd98c109d62.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=21539892bd315c6043956be7bdb0cbe6/894443a98226cffcdfba8b35b8014a90f703eaa2.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=13f2ccac9c16fdfad86cc6e6848e8cea/9a0e4bfbfbedab64b7527a47f636afc379311e11.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=37639659f11f3a295ac8d5c6a924bce3/91c279310a55b31950f3b5f242a98226cffc172b.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=09f793f2d788d43ff0a991fa4d1cd2aa/6f3c269759ee3d6da00fb34c42166d224e4ade69.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=583cbe865d6034a829e2b889fb1249d9/7da88226cffc1e174b9bbbb64b90f603738de916.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=cce587af377adab43dd01b4bbbd6b36b/eea30cf431adcbef42f54a81adaf2edda2cc9f70.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=fc8fabb64d086e066aa83f4332097b5a/08d02f2eb9389b500bd4d7d58435e5dde7116e0a.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=bad0967c38dbb6fd255be52e3925aba6/ae539822720e0cf33cc06c7c0b46f21fbe09aa07.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=4c219282e4dde711e7d243fe97eecef4/ef42ad4bd11373f01b414d18a50f4bfbfbed043f.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=5c33e5a8bf096b6381195e583c328733/ef59ccbf6c81800a4fadab89b03533fa838b47e9.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=694ea4699d82d158bb8259b9b00b19d5/8e50f8198618367a62f35d5a2f738bd4b21ce5c4.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=75b71de2b219ebc4c0787691b227cf79/d751352ac65c10385fc5ec45b3119313b17e89fa.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=e85eb058cf1b9d168ac79a69c3dfb4eb/64aea40f4bfbfbed35fc14f879f0f736aec31f94.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=fb0c5d5a2f738bd4c421b239918a876c/f5ee76094b36acaf0f65b47b7dd98d1000e99cb4.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b6723688b90e7bec23da03e91f2fb9fa/ea0635fae6cd7b89112218040e2442a7d8330eef.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=d4b5a14a5366d0167e199e20a72ad498/4c0f0cf3d7ca7bcbe728e5a8bf096b63f724a8e3.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b84964f242a98226b8c12b2fba83b97a/2e395343fbf2b211c09e63c9cb8065380dd78e82.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=04c3e9443b87e9504217f3642039531b/05c69f3df8dcd10008621ea6738b4710b8122fb8.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=ad53875037d12f2ece05ae687fc3d5ff/45889e510fb30f2494180a84c995d143ac4b03bc.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=5b9860aeeac4b7453494b71efffd1e78/0b2bc65c10385343aa3f61a69213b07ecb808842.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=35882481aec379317d688621dbc5b784/88013af33a87e950785215eb11385343faf2b4f5.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=2ad04ea1fcfaaf5184e381b7bc5594ed/75fafbedab64034f9c3b2481aec379310b551d40.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=814c097350da81cb4ee683c56267d0a4/782209f7905298225e2cd844d6ca7bcb0a46d41f.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=d60df942e1fe9925cb0c695804a95ee4/8d18ebc4b74543a96e021b4b1f178a82b9011419.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b9cb63f242a98226b8c12b2fba83b97a/2e395343fbf2b211c11c64c9cb8065380cd78e0c.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=6c1eaf5b55e736d158138c00ab514ffc/d8cc7b899e510fb3db349610d833c895d1430c0d.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=a18570757c1ed21b79c92eed9d6fddae/6bfab2fb43166d22695bf413472309f79052d20e.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=34e22381aec379317d688621dbc5b784/88013af33a87e950793812eb11385343fbf2b40f.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=33239710d833c895a67e9873e1127397/244d510fd9f9d72a5c5ef09ad52a2834349bbb04.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=131d23b4728da9774e2f86238050f872/32d6912397dda144f4b98c35b3b7d0a20df48682.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=99bb027d7acb0a4685228b315b62f63e/ef08b3de9c82d15859f7b936810a19d8bd3e42c5.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=0298337a7a899e51788e3a1c72a6d990/c8256b600c338744dc9acffb500fd9f9d62aa0df.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=5ce70dcb8ad4b31cf03c94b3b7d7276f/48084b36acaf2eddb5c65f618c1001e939019307.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=5d5b0ccb8ad4b31cf03c94b3b7d7276f/48084b36acaf2eddb47a5e618c1001e9380193ab.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=73b8ff7c50da81cb4ee683c56264d0a4/782209f790529822acd82e4bd6ca7bcb0b46d454.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=fdcdb5b2314e251fe2f7e4f09784c9c2/16391f30e924b89915f86eb06f061d950b7bf677.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=6a438de9f2deb48ffb69a1d6c01e3aef/9565034f78f0f736387a5b890b55b319eac413b6.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=862cd58eaec379317d688621dbc6b784/88013af33a87e950cbf6e4e411385343faf2b452.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b47767118326cffc692abfba89004a7d/6d42fbf2b2119313b34cee3864380cd791238d2f.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=e98093fd42a98226b8c12b2fba83b97a/2e395343fbf2b211915794c6cb8065380cd78e39.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b8640487b90e7bec23da03e91f2fb9fa/ea0635fae6cd7b891f342a0b0e2442a7d8330eda.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=4031f330d53f8794d3ff4826e21a0ead/189659ee3d6d55fb608f66ae6c224f4a21a4ddea.jpg");
        fileUrlList.add("https://imgsa.baidu.com/forum/w%3D580/sign=b9458a86b03533faf5b6932698d2fdca/b5d5b31c8701a18b274b11c79f2f07082938fe93.jpg");


        long start = System.currentTimeMillis();
        for(String fileUrl :fileUrlList){
            FileUtils.download(fileUrl,downloadPath);
        }
        long end = System.currentTimeMillis();
        System.out.println(fileUrlList.size() + "个文件已下载完成，耗时：" + ( end - start) + "毫秒");


        System.out.println("多线程文件下载============================");
        int threadHandleCount = 10;//每个线程下载的文件个数
//        int threadToCreat = (int)fileUrlList.size() / threadHandleCount;//假设每个线程下载10个文件，计算出需要穿件多少个线程
//        int yuShu = fileUrlList.size() % threadHandleCount; //看是否有余数，有的话，则在需要再创建一个线程来处理

         start = System.currentTimeMillis();
        List<DownloadThread> downloadThreadList = new ArrayList<DownloadThread>();
        DownloadThread downloadThread = null;
        //整除的情况
        for(int i = 0; i<fileUrlList.size() ;i++){
            if( i%10 == 0){
                if(null != downloadThread ){
                    downloadThreadList.add(downloadThread);
                }
                downloadThread = new DownloadThread();
            }
            downloadThread.addFileUrl(fileUrlList.get(i));
        }
        //如果有余数的，也要加进来
        if(null != downloadThread &&  null != downloadThread.getFileUrlList()  && !downloadThread.getFileUrlList().isEmpty()){
            downloadThreadList.add(downloadThread);
        }
        System.out.println(downloadThreadList);

        THREAD_NUMBER = downloadThreadList.size();
        sCountDownLatch = new CountDownLatch(THREAD_NUMBER);
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(THREAD_NUMBER);
        for(DownloadThread downloadThread1 : downloadThreadList){
            //放入线程池中，执行线程
            fixedThreadPool.execute(downloadThread1);
        }
        sCountDownLatch.await();//导致当前线程（即主线程）等待直到latch的计数降为0（除非子线程被打断）
        System.out.println(THREAD_NUMBER + "个子线程已经执行完毕");
        end = System.currentTimeMillis();
        System.out.println(fileUrlList.size() + "个文件已下载完成，耗时：" + ( end - start) + "毫秒");

    }
    private static class DownloadThread implements Runnable{

        protected List<String> fileUrlList = new ArrayList<String>();

        public List<String> getFileUrlList() {
            return fileUrlList;
        }

        public void setFileUrlList(List<String> fileUrlList) {
            this.fileUrlList = fileUrlList;
        }


        public void addFileUrl(String fileUrl){
            if(StringUtil.isNotEmpty(fileUrl)){
                fileUrlList.add(fileUrl);
            }
        }

        @Override
        public void run() {
            for(String str :fileUrlList){
                FileUtils.download(str,downloadPath);
            }
            sCountDownLatch.countDown();
        }
    }
}

