package multicapmpus.kb3.kb3project.service;

import java.util.List;


import org.apache.ibatis.annotations.Param;

import multicapmpus.kb3.kb3project.entity.Budget;
import multicapmpus.kb3.kb3project.entity.BudgetList;
import multicapmpus.kb3.kb3project.entity.Consume;
import multicapmpus.kb3.kb3project.entity.ConsumePlusCategory;

public interface BudgetService {
	//public List<Budget> getBudgetList();
	//Budget getBudgetByNo(int user_No);
	
	//���� ���
	int saveBudget(Budget budget);
	//���� ����Ʈ �����ֱ�
	List<BudgetList> findbudgetAll(int user_No);
	//���� �� �Һ� ����Ʈ �����ֱ�
	List<ConsumePlusCategory> findbudgetC(int user_No, int bd_No);
	//���� ����
	BudgetList getBudgetByNo(int bd_No);
	//���� ���� ��¥ �����ֱ�
	Budget getBdByNo(int bd_No);
	//버찌별 소비 max값
	ConsumePlusCategory getCategoryByNo(int user_No, int bd_No);

}