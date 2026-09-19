package com.vanillahud.config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
public final class HudConfig {
 public Map<String,ElementConfig> elements=new LinkedHashMap<>();
 public static final class ElementConfig { public boolean visible=true; public float x=10,y=10,scale=1f; public boolean background=true; }
 private static final Gson GSON=new GsonBuilder().setPrettyPrinting().create();
 public static HudConfig load(Path path){
  try{if(Files.exists(path))try(Reader r=Files.newBufferedReader(path)){HudConfig c=GSON.fromJson(r,HudConfig.class);if(c!=null){c.validate();return c;}}}catch(Exception ignored){}
  return new HudConfig();
 }
 public void validate(){if(elements==null)elements=new LinkedHashMap<>();elements.values().removeIf(java.util.Objects::isNull);for(ElementConfig c:elements.values()){c.scale=Math.max(.5f,Math.min(2f,c.scale));c.x=Math.max(0,c.x);c.y=Math.max(0,c.y);}}
 public void save(Path path){try{validate();Files.createDirectories(path.getParent());try(Writer w=Files.newBufferedWriter(path)){GSON.toJson(this,w);}}catch(Exception ignored){}}
 public ElementConfig get(String id,float x,float y){ElementConfig c=elements.computeIfAbsent(id,k->{ElementConfig n=new ElementConfig();n.x=x;n.y=y;return n;});c.scale=Math.max(.5f,Math.min(2f,c.scale));return c;}
}
