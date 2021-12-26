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

### 使用以上打包插件时，需要替换打包后的文件：\org\springframework\boot\loader\JarLauncher.class

[Ensure that JarLauncher doesn't cause root jar to be on class path twice](https://github.com/spring-projects/spring-boot/commit/2d8344d46d09c6c0de0bfe593f31b883a407f622#diff-21f8e7f126b40ecff72eb0cfe3b468a43b3c170781f4596d40260b96f97fab2c)