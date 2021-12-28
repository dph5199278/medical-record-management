# 打包插件说明

```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
</plugin>
```

[Ensure that JarLauncher doesn't cause root jar to be on class path twice](https://github.com/spring-projects/spring-boot/commit/2d8344d46d09c6c0de0bfe593f31b883a407f622#diff-21f8e7f126b40ecff72eb0cfe3b468a43b3c170781f4596d40260b96f97fab2c)

由于以上的原因，导致了从1.4.3.RELEASE及之后的plugin版本，在打包成jar之后，读取不到jsp路径。


[Optimize JarLauncher when used with exploded jar](https://github.com/spring-projects/spring-boot/commit/8f5777cf9ebce1762aa1202e03a51d60f2973d4f#diff-b7758a1c00eaa924abd6b1ec7f621874663d01107e31e3464ed35329b2670dfa)

从2.3.0.RELEASE开始需要处理这个问题，才能在打包成jar之后，读取jsp路径。

现对于打包插件提供以下解决方案：

1. 使用1.4.2.RELEASE 到 2.2.13.RELEASE，可用本路径下2.2.13.RELEASE\JarLauncher.class替换打包后的文件：\org\springframework\boot\loader\JarLauncher.class
2. 使用2.3.0.RELEASE及以上，可用本路径下2.6.2\JarLauncher.class替换打包后的文件：\org\springframework\boot\loader\JarLauncher.class(测试到2.6.2版本可用)
3. 不管使用哪个版本，将本路径下agent\jar-launcher.jar与打包后的jar放在同级目录下作为javaagent运行(测试到2.6.2版本可用)。例：java -javaagent:jar-launcher.jar -jar xxx.jar
4. 将JSP页面作为一个模块打包成jar，主项目再引入此依赖，这样即可解决这次提交造成的影响。

本项目是用于学习以前JSP与Spring Boot打包插件的一些源码而创建，方便广大程序猿们研究以及迁移旧的传统项目。