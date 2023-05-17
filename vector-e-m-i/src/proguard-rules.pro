# Add any ProGuard configurations specific to this
# extension here.

-keep public class com.brandon.vectoremi.VectorEMI {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'com/brandon/vectoremi/repack'
-flattenpackagehierarchy
-dontpreverify
