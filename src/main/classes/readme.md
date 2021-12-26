# explain(说明)

```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <version>2.2.13.RELEASE</version>
    <configuration>
        <classifier>exec</classifier>
    </configuration>
</plugin>
```

#### Use this package plugin, need replace package jar path: \org\springframework\boot\loader\JarLauncher.class
#### 使用以上打包插件时，需要替换打包后的文件：\org\springframework\boot\loader\JarLauncher.class

[Ensure that JarLauncher doesn't cause root jar to be on class path twice](https://github.com/spring-projects/spring-boot/commit/2d8344d46d09c6c0de0bfe593f31b883a407f622#diff-21f8e7f126b40ecff72eb0cfe3b468a43b3c170781f4596d40260b96f97fab2c)

#### Due to this commit, the JSP packaged in later versions cannot be used.
#### 由于以上的提交，导致以后的plugin版本打包出来的jar包无法访问到JSP文件。（本身这个plugin打包就不用二次引入jar包，这个逻辑的提交，我个人是赞成的）

#### JSP是已被废弃的引擎，因此不可能要求Spring Boot团队将这部分再加上来，因为后面的引擎都没有问题。还有一种解决办法是：将JSP页面作为一个模块打包成jar，主项目再引入此依赖，这样即可解决这次提交造成的影响。
