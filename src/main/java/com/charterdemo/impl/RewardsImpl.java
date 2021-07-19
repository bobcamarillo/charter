package com.charterdemo.impl;

import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.charterdemo.entity.Purchase;
import com.charterdemo.service.RewardsService;

@Service
public class RewardsImpl implements RewardsService {

    private static final int NUM_OF_FIELDS = 6;

    public final Map<Integer, ArrayList<Purchase>> dataMap = new HashMap<>();

    public RewardsImpl() {
	//This service should get data from a DB. For sample purposes, we are
	//building a map with data obtained from a CSV with random data set.
	//Data comes in the same order as Purchase fields.
	System.out.println("Loading data...");
	try {
	    readData();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    @Override
    public int calculateRewards(ArrayList<Purchase> pList) {
	System.out.println("List to check: ");
	System.out.println(pList);
	int result = 0;
	for (Purchase p : pList) {
	    int subtotal = p.getSubtotal().intValue();
	    if (subtotal > 100) {
		result = result + (2 * (subtotal - 100)) + 50;
	    } else if (subtotal > 50) {
		result = result + (subtotal - 50);
	    }
	}
	System.out.println("Result: " + result);
	return result;
    }

    @Override
    public int getRewards(int userId) {
	//We would call a Factory to get from DB the Purchases from userId.
	//For sample purposes, we use the map created on constructor.
	//NOTICE that data is from the last 3 months.
	ArrayList<Purchase> pList = dataMap.get(userId);
	if (pList == null) {
	    return 0;
	}

	System.out.println("User: " + userId);
	return calculateRewards(pList);
    }

    private void readData() throws Exception {
	File file = new ClassPathResource("sampleData.csv").getFile();
        List<String> csvRows = null;
        try (Stream<String> reader = Files.lines(file.toPath())) {
            csvRows = reader.collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (csvRows != null) {
            csvToMap(csvRows);
            //System.out.println(dataMap);
        }
    }

    private void csvToMap(List<String> csv) {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
        //get all rows
        csv.stream().map(e -> e.split(","))
            .forEach(row -> {
		    try {
			int purchaseId = Integer.parseInt(row[0]);
			int userId = Integer.parseInt(row[1]);
			Purchase purchase =
			    new Purchase(purchaseId, userId,
					 sdf.parse(row[2]),
					 new BigDecimal(row[3]),
					 new BigDecimal(row[4]),
					 new BigDecimal(row[5]));
			ArrayList<Purchase> pList = dataMap.get(userId);
			if (pList == null) {
			    pList = new ArrayList<>();
			    dataMap.put(userId, pList);
			}
			pList.add(purchase);
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		});

    }
}
