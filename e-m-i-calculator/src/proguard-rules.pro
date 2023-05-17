# Add any ProGuard configurations specific to this
# extension here.

-keep public class com.brandonang.emicalculator.EMICalculator {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'com/brandonang/emicalculator/repack'
-flattenpackagehierarchy
-dontpreverify
