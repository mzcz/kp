package com.kp.spring.repository;

import com.kp.spring.domain.BalanceDtos;
import com.kp.spring.domain.BalanceReportDto;
import com.kp.spring.domain.CategoryDto;
import com.mysema.query.Tuple;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.kp.spring.domain.QBalance.balance;
import static com.kp.spring.domain.QCategory.category;

@Repository
public class BalanceDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    public List<BalanceDtos> getAvialableBalance(){

        String SearchQuery = " select b.id, b.name, b.CATEGORY_ID, c.name as type_name, " +
                "c.type, b.amount, b.APPROVERS, b.DESCRIPTION as content ," +
                " b.CREATE_DATE, b.CREATE_BY from balance b\n" +
                "        join category c on b.CATEGORY_ID = c.ID" +
                " order by b.id desc";

        return em.createNativeQuery(SearchQuery,BalanceDtos.class).getResultList();
    };

    @SuppressWarnings("unchecked")
    public List<BalanceDtos>  getAvialableBalance2(String bilansType, int month){

        List<BalanceDtos> listTaskItemDto = new ArrayList<>();
        JPAQuery query = new JPAQuery(em);

        final List<Tuple> myList = query.from(balance)
                .join(balance.category)
                .where(balance.category.type.contains(bilansType)
                        .and(balance.createDate.month().in(month)
                               // .and(balance.category.id.in(1))
                ))
                .orderBy(balance.id.desc())
                .list(balance.id, balance.name, balance.category.id, balance.category.name, balance.category.type,
                        balance.amount, balance.approvers, balance.content, balance.createDate, balance.createBy);

        for (Tuple taskDto : myList){
            listTaskItemDto.add(new BalanceDtos(
                    taskDto.get(balance.id),
                    taskDto.get(balance.name),
                    taskDto.get(balance.category.id),
                    taskDto.get(balance.category.name),
                    taskDto.get(balance.category.type),
                    taskDto.get(balance.amount),
                    taskDto.get(balance.approvers),
                            taskDto.get(balance.content),
                                    taskDto.get(balance.createDate),
                                    taskDto.get(balance.createBy)));
        }
        return listTaskItemDto;
    };


    @SuppressWarnings("unchecked")
    public List<BalanceDtos>  getAvialableBalance3(int month, long idCategory){

        List<BalanceDtos> listTaskItemDto = new ArrayList<>();
        JPAQuery query = new JPAQuery(em);

        final List<Tuple> myList = query.from(balance)
                .join(balance.category)
                .where((balance.createDate.month().in(month)
                                 .and(balance.category.id.in(idCategory))
                        ))
                .orderBy(balance.id.desc())
                .list(balance.id, balance.name, balance.category.id, balance.category.name, balance.category.type,
                        balance.amount, balance.approvers, balance.content, balance.createDate, balance.createBy);

        for (Tuple taskDto : myList){
            listTaskItemDto.add(new BalanceDtos(
                    taskDto.get(balance.id),
                    taskDto.get(balance.name),
                    taskDto.get(balance.category.id),
                    taskDto.get(balance.category.name),
                    taskDto.get(balance.category.type),
                    taskDto.get(balance.amount),
                    taskDto.get(balance.approvers),
                    taskDto.get(balance.content),
                    taskDto.get(balance.createDate),
                    taskDto.get(balance.createBy)));
        }
        return listTaskItemDto;
    };

    public List<CategoryDto> getCategory(String type){

        JPAQuery query = new JPAQuery(em);

        final List<Tuple> myList = query.from(category)
                .where(category.type.contains(type))
                .orderBy(category.id.asc())
                .list(category.id, category.name, category.type);

        return myList.stream()
                .map(t -> new CategoryDto(t.get(category.id), t.get(category.name), t.get(category.type)))
                .collect(Collectors.toList());

    }

    public List<BalanceReportDto> getBilans3(){

        List<BalanceReportDto> balanceReportDtos = new ArrayList<>();

        List<CategoryDto> categoryReportIncome = getCategory("Przychody");

        for (CategoryDto categoryReportDto: categoryReportIncome) {

            List<BalanceDtos> balance = getAvialableBalance3(4,categoryReportDto.getId());
        }


        return balanceReportDtos;
    }

    public List<BigDecimal>  getBilansDetailsAmount(int month) {

        List<BigDecimal> values = new ArrayList<>();

        List<CategoryDto> categoryReportIncome = getCategory("Przychody");

        for (CategoryDto categoryReportDto: categoryReportIncome) {

            List<BalanceDtos> balance = getAvialableBalance3(month,categoryReportDto.getId());

            values.add(balance.stream()
                    .map(BalanceDtos::getAmount)
                    .reduce(BigDecimal.ZERO, (sum,current) -> sum = sum.add(current)));

        }

        return values;
    }

    public BigDecimal getBilansDetailsAmount1(int month, long categoryId) {



            List<BalanceDtos> balance = getAvialableBalance3(month,categoryId);

            return
            balance.stream()
                    .map(BalanceDtos::getAmount)
                    .reduce(BigDecimal.ZERO, (sum,current) -> sum = sum.add(current));


    }

    public BigDecimal getBilansAmount(String bilansType, int month) {

        List<BalanceDtos> balance = getAvialableBalance2(bilansType, month);

        return balance.stream()
                .map(BalanceDtos::getAmount)
                .reduce(BigDecimal.ZERO, (sum,current) -> sum = sum.add(current));
    }

    public List<BalanceReportDto> getActiveCash(){

        BalanceReportDto balanceReportDto1 = new BalanceReportDto();
        List<BalanceReportDto> balanceReportDtos = new ArrayList<>();

        List<CategoryDto> categoryReportIncome = getCategory("Przychody");

        for (CategoryDto categoryReportDto: categoryReportIncome) {

            int i = 0;
            List<BigDecimal> resultPrzychody = new ArrayList<>();

            BalanceReportDto balanceReportDto11 = new BalanceReportDto();
            while (i < 12) {
                i++;

                BigDecimal total = getBilansDetailsAmount1(i, categoryReportDto.getId());
                resultPrzychody.add(total);
                balanceReportDto11.setName(categoryReportDto.getName());
                switch (i) {
                    case 1:
                        balanceReportDto11.setJan(total);
                        break;
                    case 2:
                        balanceReportDto11.setFeb(total);
                        break;
                    case 3:
                        balanceReportDto11.setMar(total);
                        break;
                    case 4:
                        balanceReportDto11.setApr(total);
                        //result.add(total);
                        break;
                    case 5:
                        balanceReportDto11.setMay(total);
                       // result.add(total);
                        break;
                    case 6:
                        balanceReportDto11.setJun(total);
                       // result.add(total);
                        break;
                    case 7:
                        balanceReportDto11.setJul(total);
                       // result.add(total);
                        break;
                    case 8:
                        balanceReportDto11.setAug(total);
                        //result.add(total);
                        break;
                     case 9:
                         balanceReportDto11.setSep(total);
                        // result.add(total);
                        break;
               /* case 10: balanceReportDto2.setJan(total);
                    break;
                case 11: balanceReportDto2.setJan(total);
                    break;
                case 12: balanceReportDto2.setJan(total);
                    break;*/
                    default:
                        break;
                }

            }
            //Razem
            balanceReportDto11.setRazem(resultPrzychody.stream()
                    .reduce(BigDecimal.ZERO, (sum,current) -> sum = sum.add(current)));

            balanceReportDtos.add(balanceReportDto11);
        }

        BigDecimal income;
        int i=0;
        List<BigDecimal> resultPrzychody = new ArrayList<>();
        while(i < 12) {
            i++;
            BigDecimal total = getBilansAmount("Przychody", i);
            resultPrzychody.add(total);
            balanceReportDto1.setName("Podsumowanie Przychody");
            switch (i) {
                case 1:  balanceReportDto1.setJan(total);
                    break;
                case 2:  balanceReportDto1.setFeb(total);

                    break;
                case 3:  balanceReportDto1.setMar(total);

                    break;
                case 4:  balanceReportDto1.setApr(total);

                    break;
                case 5:  balanceReportDto1.setMay(total);

                    break;
                case 6:  balanceReportDto1.setJun(total);

                    break;
                case 7:  balanceReportDto1.setJul(total);

                    break;
                case 8: balanceReportDto1.setAug(total);
                    break;
                case 9: balanceReportDto1.setSep(total);
                    break;
                /*case 10: balanceReportDto1.setJan(total);
                    break;
                case 11: balanceReportDto1.setJan(total);
                    break;
                case 12: balanceReportDto1.setJan(total);
                    break;*/
                default:
                    break;
            }
        }
        //Razem
        income =resultPrzychody.stream()
                .reduce(BigDecimal.ZERO, (sum,current) -> sum = sum.add(current));
        balanceReportDto1.setRazem(income);

        balanceReportDtos.add(balanceReportDto1);


        List<CategoryDto> categoryReportOutCome = getCategory("Rozchody");

        for (CategoryDto categoryReportDto: categoryReportOutCome) {

            i = 0;
            List<BigDecimal> resultRozchody = new ArrayList<>();
            BalanceReportDto balanceReportDto21 = new BalanceReportDto();
            while (i < 12) {
                i++;

                BigDecimal total = getBilansDetailsAmount1(i, categoryReportDto.getId());
                resultRozchody.add(total);
                balanceReportDto21.setName(categoryReportDto.getName());
                switch (i) {
                    case 1:
                        balanceReportDto21.setJan(total);
                        break;
                    case 2:
                        balanceReportDto21.setFeb(total);
                        break;
                    case 3:
                        balanceReportDto21.setMar(total);
                        break;
                    case 4:
                        balanceReportDto21.setApr(total);
                        break;
                    case 5:
                        balanceReportDto21.setMay(total);
                        break;
                    case 6:
                        balanceReportDto21.setJun(total);
                        break;
                    case 7:
                        balanceReportDto21.setJul(total);
                        break;
                    case 8:
                        balanceReportDto21.setAug(total);
                        break;
                    case 9:
                        balanceReportDto21.setSep(total);
                    break;
               /* case 10: balanceReportDto2.setJan(total);
                    break;
                case 11: balanceReportDto2.setJan(total);
                    break;
                case 12: balanceReportDto2.setJan(total);
                    break;*/
                    default:
                        break;
                }
            }
            //Razem
            balanceReportDto21.setRazem(resultRozchody.stream()
                    .reduce(BigDecimal.ZERO, (sum,current) -> sum = sum.add(current)));
            balanceReportDtos.add(balanceReportDto21);
        }

        i=0;
        BigDecimal outCome;
        List<BigDecimal> resultRozchody = new ArrayList<>();
        BalanceReportDto balanceReportDto2 = new BalanceReportDto();
        while(i < 12) {
            i++;
            BigDecimal total = getBilansAmount("Rozchody", i);
            resultRozchody.add(total);
            balanceReportDto2.setName("Podsumowanie Rozchody");
            switch (i) {
                case 1:  balanceReportDto2.setJan(total);
                    break;
                case 2:  balanceReportDto2.setFeb(total);
                    break;
                case 3:  balanceReportDto2.setMar(total);
                    break;
                case 4:  balanceReportDto2.setApr(total);
                    break;
                case 5:  balanceReportDto2.setMay(total);
                    break;
                case 6:  balanceReportDto2.setJun(total);
                    break;
                case 7:  balanceReportDto2.setJul(total);
                    break;
                case 8:  balanceReportDto2.setAug(total);
                    break;
                case 9:  balanceReportDto2.setSep(total);
                    break;
               /* case 10: balanceReportDto2.setJan(total);
                    break;
                case 11: balanceReportDto2.setJan(total);
                    break;
                case 12: balanceReportDto2.setJan(total);
                    break;*/
                default:
                    break;
            }
        }
        //Razem
        outCome = resultRozchody.stream()
                .reduce(BigDecimal.ZERO, (sum,current) -> sum = sum.add(current));
        balanceReportDto2.setRazem(outCome);
        balanceReportDtos.add(balanceReportDto2);

        i=0;
        BigDecimal finalCash;
        BigDecimal cash_all = BigDecimal.ZERO;
        BalanceReportDto balanceReportDtoFinal = new BalanceReportDto();
        while(i < 12) {
            i++;
            BigDecimal totalIncome = getBilansAmount("Przychody", i);

            BigDecimal totalOutcome = getBilansAmount("Rozchody", i);

            BigDecimal cash = totalIncome.subtract(totalOutcome);
            cash_all =cash_all.add(cash);

            balanceReportDtoFinal.setName("Gotowka");
            switch (i) {
                case 1:  balanceReportDtoFinal.setJan(cash_all);
                    break;
                case 2:  balanceReportDtoFinal.setFeb(cash_all);
                    break;
                case 3:  balanceReportDtoFinal.setMar(cash_all);
                    break;
                case 4:  balanceReportDtoFinal.setApr(cash_all);
                    break;
                case 5:  balanceReportDtoFinal.setMay(cash_all);
                    break;
                case 6:  balanceReportDtoFinal.setJun(cash_all);
                    break;
                case 7:  balanceReportDtoFinal.setJul(cash_all);
                    break;
                case 8:  balanceReportDtoFinal.setAug(cash_all);
                    break;
                 case 9:  balanceReportDtoFinal.setSep(cash_all);
                    break;
                /*case 10: balanceReportDtoFinal.setJan(cash_all);
                    break;
                case 11: balanceReportDtoFinal.setJan(cash_all);
                    break;
                case 12: balanceReportDtoFinal.setJan(cash_all);
                    break;*/
                default:
                    break;
            }

            //System.out.println(totalIncome);
            //System.out.println(totalOutcome);
            //System.out.println("Gotówka " + cash_all + " w miesiącu "+ i);
        }
        finalCash = income.subtract(outCome);
        balanceReportDtoFinal.setRazem(finalCash);
        balanceReportDtos.add(balanceReportDtoFinal);
        return balanceReportDtos;
    }


    @SuppressWarnings("unchecked")
    public List<BalanceReportDto> getBalanceReport(){

        String SearchQuery = " select name, jan, feb, mar, apr, may, jun, jul, aug, sep, razem from balance_total_vw ";

        return em.createNativeQuery(SearchQuery,BalanceReportDto.class).getResultList();
    };
}
