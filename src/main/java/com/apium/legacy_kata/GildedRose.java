package com.apium.legacy_kata;

class GildedRose {

  Item[] items;

  private final String CONJURED_ITEM = "Conjured";

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      if (item.name.contains(CONJURED_ITEM)) {
        updateConjuredItems(item);
      } else {
        updateNormalItems(item);
      }
    }
  }

  private void updateConjuredItems(Item item) {
    item.sellIn = item.sellIn - 1;

    if (item.sellIn > 0) {
      item.quality = item.quality - 2;
    }else{
      item.quality = item.quality - 4;
    }

    if(item.quality < 0) {
      item.quality = 0;
    }
  }

  private void updateNormalItems(Item item) {
    if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
      if (item.quality > 0) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
          item.quality = item.quality - 1;
        }
      }
    } else {
      if (item.quality < 50) {
        item.quality = item.quality + 1;

        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
          if (item.sellIn < 11) {
            if (item.quality < 50) {
              item.quality = item.quality + 1;
            }
          }

          if (item.sellIn < 6) {
            if (item.quality < 50) {
              item.quality = item.quality + 1;
            }
          }
        }
      }
    }

    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
      item.sellIn = item.sellIn - 1;
    }

    if (item.sellIn < 0) {
      if (!item.name.equals("Aged Brie")) {
        if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
          if (item.quality > 0) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
              item.quality = item.quality - 1;
            }
          }
        } else {
          item.quality = 0;
        }
      } else {
        if (item.quality < 50) {
          item.quality = item.quality + 1;
        }
      }
    }
  }
}