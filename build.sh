chmod +x gradlew

./gradlew clean
./gradlew testReleaseUnitTest

if [[ "$TRAVIS_BRANCH" == "master" ]]
then

  echo $TRAVIS_COMMIT
  ./gradlew assembleRelease

  date=`date +%Y-%m-%d`
  chemin='./app/build/outputs/apk/release/'
  oldApk=$chemin'app-release-unsigned.apk'
  newApk=$chemin'release_'$date'.apk'

  mv $oldApk $newApk

fi