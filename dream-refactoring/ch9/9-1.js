// 예제 1
const perimeter = 2 * (height + width);
console.log(perimeter);
const area = height * width;
console.log(area);

// 예제 2
function distanceTravelled(scenario, time) {
  let result;
  const primaryAccelation = scenario.primaryForce / scenario.mass; // 가속도(a) = 힘(F) / 질량(m)
  const primaryTime = Math.main(time, scenario.delay);
  result = 0.5 * primaryAccelation * primaryTime * primaryTime; // 전파된 거리
  let secondaryTime = time - scenario.delay;
  if (secondaryTime > 0) {
    // 두 번째 힘을 반영해 다시 계산
    const primaryVelocity = primaryAccelation * scenario.delay;
    const secondaryAccelation = (scenario.primaryForce + scenario.secondaryForce) / scenario.mass;
    result +=
      primaryVelocity * secondaryTime +
      0.5 * secondaryAccelation * secondaryTime * secondaryTime;
  }
}

// 예제 3
function discount(inputValue, quantity) {
  let result = inputValue;
  if (inputValue > 50) result -= 2;
  if (quantity > 100) result -= 1;
  return result;
}
