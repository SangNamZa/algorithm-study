function solution(cacheSize, cities) {
  var answer = 0;
  let lowerCity = [];
  let cityArray = [];
  // 도시 이름 소문자화 하고, 도시가 이미 있는지 찾는다
  // 도시가 이미 있는게 아니고,캐시 공간 잇으면 추가하면서 +1
  // 도시가 이미 있는게 아니고, 캐시 공간 없으면 젤 앞꺼 빼면서 +5
  // 이미 도시가 있으면 젤 뒤로 옭기면서  hit +1

  for (let i = 0; i < cities.length; i++) {
    lowerCity.push(cities[i].toLowerCase());
    let haveCity = cityArray.find((element) => element === lowerCity[i]);
    if (haveCity === false) {
      if (cityArray.length < cacheSize) {
        cityArray.push(lowerCity[i]);
        answer += 1;
      } else if (cityArray.length === cacheSize) {
        cityArray.splice(0, 1);
        answer += 5;
      }
    } else if (haveCity === true) {
      cityArray.filter((element) => element !== lowerCity[i]);
      cityArray.push(lowerCity[i]);
      answer += 1;
    }
  }
  return answer;
}
