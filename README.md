# ResHotFix
res hot fix,load external storage xml layout and other resource and so on .

# usage
1.修改hotfix_1下的xml布局文件，然后使用状态栏工具的Build->Build Bundle(s)/Apk(s)生成apk文件
2.将生成的apk文件拷贝到主工程下的assets目录，然后运行主工程即可看到修改后的效果

# explain
1.本项目实现了如何加载外部xml布局等资源文件，可以实现服务端动态下发布局，可以实现换肤技术等等
2.缺点就是只支持资源文件的动态加载，没有代码层面的动态加载，需要的话自己通过classloader实现吧。
