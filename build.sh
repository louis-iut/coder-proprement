
chmod +x gradlew

./gradlew clean
./gradlew assembleDebugUnitTest
./gradlew build

chemin='/app/build/outputs/apk'
var1="app/build/"
var2=`date +%Y-%m-%d`
var3=".apk"
link=$var1$var2$var3
mv app/build/outputs/apk/app-debug.apk $link

echo "fichier "$var2$var3" généré vers "$link

