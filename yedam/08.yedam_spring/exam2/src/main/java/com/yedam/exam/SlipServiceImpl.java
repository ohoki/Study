package com.yedam.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlipServiceImpl implements SlipService{

	@Autowired	SlipDAO dao;
	
	@Override
	public Map<String, String> insertSlip(List<Slip> slipList) {		
		Map<String, String> map = new HashMap<String, String>();
		int result = 0;
		int count = 0;
		List<String> list = new ArrayList<String>();
		
		for(Slip s : slipList) {
			//20000이하 사원 맵 등록
			if(s.getSlipAmount() <= 20000) {
				String empId = s.getCustomer().substring(0, s.getCustomer().indexOf('_'));
				s.setSlipAmount(20000);
				list.add(empId);
			}
			//db등록
			result = dao.insertSlip(s);
			
			if(result == 1) {
				count++;
			}
		}	
		
		String[] array = list.toArray(new String[list.size()]);
		String strArray = Arrays.toString(array);
		
		
		map.put("수신건수", String.valueOf(count));
		map.put("empList", strArray);

		return map;	// 처리내용 
	}

}
