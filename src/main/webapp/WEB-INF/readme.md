pom.xml添加
```xml
<packaging>war</packaging>

...

<build>
    ...
    <resources>
        <resource>
            <directory>src/main/webapp</directory>
            <filtering>false</filtering>
            <excludes>
                <exclude>**/*.md</exclude>
            </excludes>
        </resource>
        ...
    </resources>
</build>
```

#### 要打成war包，除了以上添加，还有点修改 ####
* pom.xml的jsp、tomcat等引入添加provided