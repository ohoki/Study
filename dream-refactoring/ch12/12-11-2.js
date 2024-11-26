class Scroll {
  constructor(id, dataLastCleaned, CatalogItem) {
    super(id, title, tags);
    this._lastCleaned = dataLastCleaned;
  }

  get id() {
    return this._id;
  }

  get title() {
    return this._CatalogItem.title;
  }

  hasTag(aString) {
    return this._CatalogItem.title.hasTag(aString);
  }

  needsCleaning(targetDate) {
    const threshold = this.hasTag('revered') ? 700 : 1500;

    return this.daysSinceLastCleaning(targetDate) > threshold;
  }

  daysSinceLastCleaning(targetDate) {
    return this._lastCleaned.until(targetDate, ChronoUnit.DAYS);
  }
}

const scroll = aDocument.map(
  (record) => 
    new Scroll(
      record.Id,
      LocalDate.parse(record.lastCleaned),
      record.catalogData.id,
      catalog
    )
)
