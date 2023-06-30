package com.ktb.codewar;
import java.util.Arrays;
import java.util.List;

public class PaginationHelper<I> {
    List<I> collection;
    int itemsPerPage;

    public static void main(String[] args) {
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24), 10);
//        System.out.println("helper.pageCount() = " + helper.pageCount());
//        System.out.println("helper.itemCount() = " + helper.itemCount());
//        System.out.println("helper.pageItemCount(0) = " + helper.pageItemCount(0));
//        System.out.println("helper.pageItemCount(1) = " + helper.pageItemCount(1));
        System.out.println("helper.pageItemCount(2) = " + helper.pageIndex(22));
    }

    public PaginationHelper(List<I> collection, int itemsPerPage) {
        System.out.println("collection");
        collection.forEach(e->System.out.println(e+","));
        System.out.println("itemsPerPage");
        System.out.println("itemsPerPage = " + itemsPerPage);

        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return this.collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
//        int count = this.collection.size() / itemsPerPage;
//        if (this.collection.size() % itemsPerPage != 0) {
//            count++;
//        }
//        return count;

        return (int)Math.ceil(itemCount() / (float)itemsPerPage);
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex < 0 || pageIndex >= pageCount()) {
            return -1;
        }
        if (pageCount()- 1 == pageIndex && this.collection.size() % itemsPerPage != 0) { // last page
            return this.collection.size() % itemsPerPage;
        }
        return itemsPerPage;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        System.out.println("itemIndex = " + itemIndex);
        if (itemIndex < 0 || itemIndex >= collection.size()) {
            return -1;
        }
        int i = (itemIndex + 1) / itemsPerPage;
        if ((itemIndex + 1) % itemsPerPage != 0) {
            i++;
        }
        return  i -1;
    }


}
