package multicapmpus.kb3.kb3project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import multicapmpus.kb3.kb3project.entity.Budget;
import multicapmpus.kb3.kb3project.entity.BudgetList;
import multicapmpus.kb3.kb3project.entity.Consume;
import multicapmpus.kb3.kb3project.entity.ConsumePlusCategory;
import multicapmpus.kb3.kb3project.mapper.BudgetMapper;

@Service
public class BudgetServiceImpl implements BudgetService {

	private final BudgetMapper budgetMapper;

	@Autowired 
	public BudgetServiceImpl(BudgetMapper budgetMapper) {	
		this.budgetMapper = budgetMapper; }
	//���� ���
	@Override 
	public int saveBudget(Budget budget) {
		int bbudget=budgetMapper.save(budget);
		return bbudget;
	}
	//���� ����Ʈ
	@Override
	public List<BudgetList> findbudgetAll(int user_No) {
		return budgetMapper.findbudgetAll(user_No);
	}
	//���� �� �Һ� ����Ʈ
	@Override
	public List<ConsumePlusCategory> findbudgetC(int user_No, int bd_No){
		return budgetMapper.findbudgetC(user_No, bd_No);
	}
	//���� ����
	@Override 
	public BudgetList getBudgetByNo(int bd_No) { 
		BudgetList bgl=budgetMapper.getBudgetByNo(bd_No); 
		return bgl; 
	}
	//���� ��¥
	@Override
	public Budget getBdByNo(int bd_No) {
		Budget bd=budgetMapper.getBdByNo(bd_No);
		return bd;
	}
	//버찌별 소비 max 값
	@Override
	public ConsumePlusCategory getCategoryByNo(int user_No, int bd_No) {
		ConsumePlusCategory cp=budgetMapper.getCategoryByNo(user_No, bd_No);
		return cp;
	}
}
