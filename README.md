# greenDAOdemo
greenDAO日常CRUD操作demo

greenDAO在初始化的时候 执行DaoSession daoSession = daoMaster.newSession();//获取session
会在内存中创建一个类似于心跳包的长期存在的小块内存,所以他的操作速度相当之快.
官方给出的图:
![](http://oenmdzxge.bkt.clouddn.com/xixi.png)

* 再flag一下grennDAO的优点:
  - 1.性能最大化,内存开销最小化(看上面)
  - 2.易于使用的API
  - 3.为Android进行高度优化
  
  
* 具体使用请看demo,从初始化到CRUD都有很详细的注释
