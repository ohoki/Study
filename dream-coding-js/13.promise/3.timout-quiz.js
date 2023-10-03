// 주어진 seconds(초)가 지나면 callback 함수를 호출함
// 단, seconds가 0보다 작으면 에러를 던지자!
function runInDelay(callback, seconds) {
  if (!seconds || seconds < 0) {
    throw new Error('초는 0보다 작을 수 없음!');
  }
  setTimeout(callback, seconds * 1000);
}

try {
  runInDelay(() => {console.log('1')}, 4);
} catch(error){}
