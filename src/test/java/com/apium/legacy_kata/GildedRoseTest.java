package com.apium.legacy_kata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

  @Test
  @DisplayName("Quality should lower one point if sellIn > 0")
  void should_update_quality() {
    Item[] items = new Item[] { new Item("foo", 1, 2) };
    GildedRose sut = new GildedRose(items);
    sut.updateQuality();
    assertEquals(1, sut.items[0].quality);
  }

  @Test
  @DisplayName("Quality should lower two points if sellIn = 0")
  void should_update_quality_faster() {
    Item[] items = new Item[] { new Item("foo", 0, 2) };
    GildedRose sut = new GildedRose(items);
    sut.updateQuality();
    assertEquals(0, sut.items[0].quality);
  }

  @Test
  @DisplayName("Should update sellIn property one point")
  void should_update_sellIn() {
    Item[] items = new Item[] { new Item("foo", 1, 2) };
    GildedRose sut = new GildedRose(items);
    sut.updateQuality();
    assertEquals(0, sut.items[0].sellIn);
  }

  @Test
  @DisplayName("Should lower two points for conjured items")
  void should_update_quality_for_conjured_items() {
    Item[] items = new Item[] { new Item("Conjured foo", 2, 3) };
    GildedRose sut = new GildedRose(items);
    sut.updateQuality();
    assertEquals(1, sut.items[0].quality);
  }

  @Test
  @DisplayName("Quality should always be bigger than zero for conjured items")
  void quality_bigger_than_zero_for_conjured_items() {
    Item[] items = new Item[] { new Item("Conjured foo", 2, 1) };
    GildedRose sut = new GildedRose(items);
    sut.updateQuality();
    assertEquals(0, sut.items[0].quality);
  }

  @Test
  @DisplayName("When sellIn is lower or equal than zero should lower quality faster")
  void should_update_quality_faster_for_conjured_items() {
    Item[] items = new Item[] { new Item("Conjured foo", 1, 4) };
    GildedRose sut = new GildedRose(items);
    sut.updateQuality();
    assertEquals(0, sut.items[0].quality);
  }

}