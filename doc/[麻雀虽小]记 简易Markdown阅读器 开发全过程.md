# [麻雀虽小]记 简易Markdown阅读器 开发全过程

[TOC]
## 序言

> 项目地址： **[https://github.com/didikee/MDReader](https://github.com/didikee/MDReader)**
> 测试文章地址： **[2017 Android 面试题 [ 基础与细节 ]](https://github.com/didikee/Android-Learning-Report/blob/master/Blog/2017%20Android%20%E9%9D%A2%E8%AF%95%E9%A2%98%20%5B%20%E5%9F%BA%E7%A1%80%E4%B8%8E%E7%BB%86%E8%8A%82%20%5D.md)**
> enjoy.

本文的程序比较简单，甚至说有些简陋，简陋到我连应用程序列表的图标都不想占用，只希望你在打开`.md`文件时不至于没有什么app可以查看，仅此而已。

整个思路我梳理下如下：

```
1. 程序名称
2. 程序功能  -->  这个很明确，只是一个可以查看`Markdown`格式文件。
3. 程序UI及其交互 （这个对于开发人员来说最麻烦，做出来的交互还可能反人类。。。）
4. 功能实现 （这个占用绝大部分时间，当然包括测试和写 Demo ）
5. 程序Icon （这个没有UI帮忙，自己只能用些简单的，还好目前有不少工具可以用）
6. 差不多完成了第一个版本 （可用而已）
```

## 具体实现过程

#### 1. 程序名称

我立马想起来的是**`MDReader`**，所以就是差个中文名字了，就叫**`Markdown阅读器`**好了，重名了就改`MD阅读器`好了。再重名再说吧。。。


#### 2. 功能 与 UI

之前我按照`Google`的官方来，有一个`DrawerLayout`,但是立马就发现我要做的本来就是一个很简单明了的东西。如果我为了把抽屉填满内容也是可以，但是我自己都觉得很臃肿。然后我立马想到了一款App----**`RE文件浏览器`**，这个App从我刚接触Android时就是玩机的必备利器，而且功能从那时起就没有什么大的改动，只是在UI上跟着潮流在走，而且此APP在`GooglePlay`的售价和评分都挺高的。我想要的其实就是这种风格的APP，稳定简单易用。
**所以，我擅做主张的把所有的UI都砍掉了！变成一个没有图标的工具服务型App。**砍完发现确实简陋了，但是感觉挺好的，后期可能加一些`CSS`样式方便导出`HTML`文件。

#### 功能实现

这个就比较灵活了，我是花了一天半的时间的。`Markdown to HTML`，Google 这个关键字，信息还是挺多的，或者 GitHub 搜索一下 `Markdown`也能找到很多开源工具。但是大部分都是基于`JavaScript`的，我对这方面不是很熟悉，只能看看，会一些Android 与JavaScript 的交互而已。所以我更希望有为Android 量身做的开源库。

我试过的有：

```
1. commonmark ： java写的，但是我使用时不支持表格
2. Markdownj： 也是java 写的
3. MarkdownView-Android： 拓展不太好，或者没发拿来直接用，而且他是用的 marked 这个开源库
4. us.feras.mdv:markdownview： 问题多多，直接放弃
5. marked： 这个看起来很不错，我借用Webview 用执行JavaScript 方法，然后把解析后的html 回传给 Android。路是通的，但是有一些问题。
6. markedj： 基于 marked.js 写的，用起来可以就没换了，推荐。
```
#### 程序图标Icon

虽然我在程序列表里不显示，但是在用户点击一个`.md`格式的文本后，我的app需要匹配到，并且显示在匹配的列表里，此时还是需要icon，Android 默认的icon看着也太寒碜了。然后我就写了两个字**`MD`**，嗯，Icon也算是做完了，哈哈。

![嗯，还行的样子吧，哈哈](ic_launcher.png)

感谢这个在线工具,有兴趣的可以收藏mark下：**[https://jgilfelt.github.io/AndroidAssetStudio/icons-launcher.html](https://jgilfelt.github.io/AndroidAssetStudio/icons-launcher.html#foreground.type=text&foreground.space.trim=0&foreground.space.pad=0&foreground.text.text=MD&foreground.text.font=Roboto&foreColor=E8EAF6%2C0&crop=0&backgroundShape=circle&backColor=3F51B5%2C100&effects=shadow&elevate=1)**

#### 市场

后期上线的话，可能只会去**酷市场**和**GooglePlay**了，当然，上线也只是为了分享而已。


## 具体实现[代码篇]

#### 1. maven 如何在Android 中使用

例如，`markedj`作者给出了maven仓库的`pom.xml`文件：

```
<dependencies>
  <dependency>
    <groupId>io.github.gitbucket</groupId>
    <artifactId>markedj</artifactId>
    <version>1.0.9</version>
  </dependency>
</dependencies>
```

在 Android 中只需要把这三个参数用 **`:`**连接起来就好了，这就是 `Gradle`可以用的：
```
dependencies {
    compile fileTree(include: ['*.jar'], dir: 'libs')
    // markdej,base on marked.js
    compile 'io.github.gitbucket:markedj:1.0.9'
    compile 'com.android.support:support-annotations:25.1.1'
}
```

#### 2. 加入CSS样式

```
<style> ##你的样式##</style>
```

我使用的是`MarkdownPad2` 的默认css样式。

样式的代码比较长，我就不贴了，可以去本文顶部的连接查看项目。

#### 3. markdown 转 html

这个都说忘记了，这个耗时最长，但是耗时越长说的就最少了，绝大部分时间都是测试，反复的看，对比生成的`html`文件。
目前APP 依赖的Android **`Webview`**去展示 `html`，但是部分手机会出现问题，比如我的OPPO测试机就不能代码块左右滑动，导致显示不全。
此时你可以用手机里的浏览器打开生成的`html`文件，应该不会出现上述问题。

#### 4. 匹配 .md 格式文件

我的唯一一个 Activity 的清淡文件：

```
<activity
            android:name=".MainActivity"
            android:label="@string/app_name"
            >
            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>
                <category android:name="android.intent.category.LAUNCHER"/>
                <data android:host="ruijun.com" android:scheme="http"/>
            </intent-filter>
            <intent-filter>
                <action android:name="android.intent.action.VIEW"/>
                <category android:name="android.intent.category.DEFAULT"/>

                <data android:scheme="file"/>
                <data android:host="*"/>
                <data android:mimeType="*/*"/>
                <data android:pathPattern=".*\\.md"/>
            </intent-filter>
            <intent-filter>
                <action android:name="android.intent.action.VIEW"/>
                <category android:name="android.intent.category.DEFAULT"/>

                <data android:scheme="file"/>
                <data android:host="*"/>
                <data android:mimeType="*/*"/>
                <data android:pathPattern=".*\\.markdown"/>
            </intent-filter>
        </activity>
```

#### 5. 隐藏程序图标

```
<intent-filter>
         <action android:name="android.intent.action.MAIN"/>
         <category android:name="android.intent.category.LAUNCHER"/>
         <data android:host="ruijun.com" android:scheme="http"/>
</intent-filter>
```

只需要这句最关键的：**`<data android:host="ruijun.com" android:scheme="http"/>`**

源码里的关键点在**`LoaderTask.loadAllAppsByBatch（）`**方法和**`Launcher.bindAllApplications（）`**方法。

参考：[隐藏APP图标](http://blog.liangruijun.com/2016/01/24/Android%E5%A5%87%E6%8A%80%E6%B7%AB%E5%B7%A7%EF%BC%9A%E9%9A%90%E8%97%8FAPP%E5%9B%BE%E6%A0%87/)

#### 6. 得到 Intent 里的文件路径

这里面只是版本的问题，不同的品牌手机也会有影响
```
public static String getPathFromUri(Context context, Uri uri) {
        //得到uri，后面就是将uri转化成file的过程
        if (context == null || uri == null) {
            return null;
        }
        String pathFromUri;
        int sdkInt = Build.VERSION.SDK_INT;
        if (sdkInt >= 19) {
            pathFromUri = Uri2Path.getRealPathFromURI_API19(context, uri);
        } else if (sdkInt >= 11 && sdkInt < 19) {
            pathFromUri = Uri2Path.getRealPathFromURI_API11to18(context, uri);
        } else {
            pathFromUri = Uri2Path.getRealPathFromURI_BelowAPI11(context, uri);
        }
        return pathFromUri;
    }
```

## 总结

放张截图吧

![截图](Screenshot_20170330-204744.png)


