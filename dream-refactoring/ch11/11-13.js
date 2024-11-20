const values = [];
function getValueForPeriod(periodNumber) {
  return values[periodNumber] ?? 0;
}

getValueForPeriod(-10);
