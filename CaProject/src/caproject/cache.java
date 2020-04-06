/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caproject;

/**
 *
 * @author Xone-pc
 */
public class cache {

    Block cache_lines[];
    int index_array[];
    double hits;
    double misses;
    int count;

    public cache() {
        //initiliza block and sets
        cache_lines = new Block[3];
        
         for(int i=0; i<3; i++){
          cache_lines[i]=new Block();
        }
       
        index_array = new int[3];
        count = 0;
        for (int i = 0; i < cache_lines.length; i++) {
            index_array[i] = -1;
        }
    }
    void place_in_cache(int block_number){
        for(int i=0;i<cache_lines.length;i++){
            if(index_array[i]==-1){
                cache_lines[i].offset=block_number;
                cache_lines[i].access_time=System.currentTimeMillis();    
                index_array[i]=block_number;
                count++;
                break;
            }
        }
    }
    int lru(){
    int oldest=0;
    long min=cache_lines[0].access_time;
    for(int i=0;i<10;i++){
        if(cache_lines[i].access_time<min){
           min=cache_lines[i].access_time;
           oldest=i;
        }
    
      }
    return oldest;
    }
    // replace the oldest plock here 
    void replace_in_cache(int block_number){
        int oldest=lru();
        cache_lines[oldest].offset=block_number;
        cache_lines[oldest].access_time=System.currentTimeMillis();    
        index_array[oldest]=block_number;
                
    }
    void placement(int block_number) {
            if (count < cache_lines.length) {
                place_in_cache(block_number);   
            }
            else if(count == cache_lines.length){
                replace_in_cache(block_number);
            }

    }


    void lookup(int block_number) {
        int found = 0;
     //   System.out.println(block_number);
        for (int i = 0; i < 3; i++) {
            if (index_array[i] == block_number) {

                if (index_array[i] == cache_lines[i].offset) {
                    System.out.println("Block found in line number: " + (i + 1));
                    found = 1;
                    ++hits;
                    cache_lines[i].access_time=System.currentTimeMillis();
                    break;
                }


            }
        }
        if (found == 0)
        {
      //      System.out.println("in found=0");
            ++misses;
            placement(block_number);
        }


    }
    
}