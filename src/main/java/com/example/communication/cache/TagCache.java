package com.example.communication.cache;

import com.example.communication.dto.TagDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TagCache {
    public static List<TagDto> get() {
        List<TagDto> TagDtoS = new ArrayList<>();
        TagDto program = new TagDto();
        program.setCategoryName("开发语言");
        program.setCategoryTags(Arrays.asList("javascript", "php", "css", "html", "html5", "java", "node.js", "python",
                "c++", "c", "golang", "objective-c", "typescript", "shell", "swift", "c#", "sass", "ruby", "bash", "less",
                "asp.net", "lua", "scala", "coffeescript", "actionscript", "rust", "erlang", "perl"));
        TagDtoS.add(program);

        TagDto framework = new TagDto();
        framework.setCategoryName("平台框架");
        framework.setCategoryTags(Arrays.asList("laravel", "spring", "express", "django", "flask", "yii", "ruby-on-rails", "tornado", "koa", "struts"));
        TagDtoS.add(framework);


        TagDto server = new TagDto();
        server.setCategoryName("服务器");
        server.setCategoryTags(Arrays.asList("linux", "nginx", "docker", "apache", "ubuntu", "centos", "缓存 tomcat", "负载均衡", "unix", "hadoop", "windows-server"));
        TagDtoS.add(server);

        TagDto db = new TagDto();
        db.setCategoryName("数据库");
        db.setCategoryTags(Arrays.asList("mysql", "redis", "mongodb", "sql", "oracle", "nosql memcached", "sqlserver", "postgresql", "sqlite"));
        TagDtoS.add(db);

        TagDto tool = new TagDto();
        tool.setCategoryName("开发工具");
        tool.setCategoryTags(Arrays.asList("git", "github", "visual-studio-code", "vim", "sublime-text", "xcode intellij-idea", "eclipse", "maven", "ide", "svn", "visual-studio", "atom emacs", "textmate", "hg"));
        TagDtoS.add(tool);
        return TagDtoS;
    }

    public static String invalidStr(String tag) {
        List<TagDto> tagDtos = get();
        String[] split = tag.split(",");
        String invalidStr = "";
        String collect = tagDtos.stream().flatMap(t -> t.getCategoryTags().stream()).collect(Collectors.joining(","));
        for (String s : split) {
            if (!collect.contains(s)) {
                invalidStr = invalidStr + s;
            }
        }
        return invalidStr;
    }
}
