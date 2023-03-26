use hr;
select * from employees;
alter table job_history
add primary key(employee_id, start_date);

# 성, 명, 급여, 입사일자, 부서번호를 출력하시오.
select last_name, first_name, salary, hire_date, department_id
from employees;

# 부서명도 출력하시오 -> join, 이때 연결고리 외래키를 찾아야 한다.

# 커미션을 받는 직원 조회 commistion_pct
# commision_pct 컬럼이 널이 아닌 경우로 조회해야 한다. 그 방법은 is not null 연산자를 사용해야 한다.
select *
from employees
where commission_pct is NOT NULL;

# 한 번이라도 부서나 직무를 변경한 적이 있는 직원을 조회
# *한 번이라도* 방법은 여러가지지만 exists 연산자를 쓸 수도 있다.

# and를 먼저 사용하기에 괄호를 사용하여 우선순위를 주어야 한다.
select *
from employees
where (department_id = 70 or department_id = 80) and last_name like 'K%';

# 이메일 주소 중 kosa.go.kr을 넣어서 => concat
# 이메일 주소 중 5자리만 출력 => substr

select 12345.678, round(12345.678, -2);
select now(), sysdate();

# 오늘부터 100일 후,
# 오늘부터 1년 후, 입사 후 30주년 일자, 
# 두 날짜 사이를 연산 입사 후 근속년수,

select now(), date_format(now(), '%m-%d-%Y');
select last_name, hire_date, date_format(hire_date, '%m-%d-%Y') 입사일자
from employees;

# 연봉을 출력, 단 커미션을 반영하여
select salary, commission_pct, salary*(1 + ifnull(commission_pct, 0))+12 커미션반영연봉, 
last_name
from employees;

# hw
select concat(last_name, first_name) 성명, concat(email, '@kosa.com'), 
truncate(((salary*(1+ifnull(commission_pct, 0)))*12)*1240, -3) 연봉,
date_format(date_add(hire_date, INTERVAL 30 YEAR), '%d-%m-%Y') 입사후30주년일자, 
truncate((curdate() - date(hire_date)) /10000, 2) 근속연수, 
hire_date 입사일자
from employees
where department_id = 80
order by 근속연수 desc;

# group by
select department_id, count(*)
from employees
group by department_id;

# 부서별 인원 수 출력하는데 1명 이하는 제외함
# 급여가 5000이상만 반영함

select department_id, count(*)
from employees
group by department_id
having count(*) > 1;

# case
select last_name, salary,
	case when salary < 5000 then 'D'
		 when salary < 7000 then 'C'
         when salary < 10000 then 'B'
         when salary < 15000 then 'A'
         else 'S'
    end sal_grade
from employees;


select
	case when salary < 5000 then 'D'
		 when salary < 7000 then 'C'
         when salary < 10000 then 'B'
         when salary < 15000 then 'A'
         else 'S'
    end sal_grade, count(*) cnt
from employees
group by (
	case when salary < 5000 then 'D'
		 when salary < 7000 then 'C'
         when salary < 10000 then 'B'
         when salary < 15000 then 'A'
         else 'S'
    end)
order by (
	case sal_grade when 'D' then 5
		 when 'C' then 4
		 when 'B' then 3
		 when 'A' then 2
		 else 1
	end);

# 입사일자가 가장 빠른 직원 3 사람을 출력, 급여가 가장 작은 3명을 출력 top n query
select * from employees order by hire_date asc limit 3;
select * from employees order by salary asc limit 3;

# 성, 입사일자, 급여, 부서명 출력 join
# department id가 없는 사람의 경우를 제외함.
select e.first_name, e.hire_date, e.salary, d.department_name, e.department_id
from employees e, departments d
where e.department_id = d.department_id;

# null을 무시하여 결과가 다르게 나온다. 아직 부서에 배치되지 않아 부서명 출력이 불가능한 경우 사라진다. => outer join
select count(*)
from employees e, departments d
where e.department_id = d.department_id;

select count(*)
from employees e;

# 아직미배치 상태의 직원은 부서명없음이라고 출력하시오.
select e.first_name, e.hire_date, e.salary, ifnull(d.department_name, '부서명없음') as 부서명
from employees e left join departments d
	on e.department_id = d.department_id;

# 관리자 이름도 출력
select e.last_name, m.last_name
from employees e join employees m on e.manager_id = m.employee_id;

# steven, king이 근무하는 부서의 부서원 정보를 출력
select department_id from employees where last_name = "king" and first_name = 'Steven';

select * from employees where department_id = 90;

select *
from employees 
where department_id = (
						select department_id 
                        from employees 
                        where last_name = 'king' and first_name = 'Steven'
					);

# 하나 이상의 row가 등장하기에 에러 => 비교 연산자가 달라져야함 
select *
from employees 
where department_id = (
						select department_id 
                        from employees 
                        where last_name = 'king'
					);
                    
# 다중 컬럼 쿼리
select *
from employees 
where department_id in (
						select department_id 
                        from employees 
                        where last_name = 'king'
					);                    
                    
# 부서별로 최고 급여를 받는 직원정보 조회
select max(salary) from employees group by department_id;

select last_name, salary, department_id 
from employees 
where (salary, department_id) in (
	select max(salary), department_id from employees group by department_id
    )
order by department_id;

# 자기 부서의 평균 급여보다 많은 급여를 받는 직원조회
# 상호연관 서브쿼리
select *
from employees e
where salary > (select avg(salary) from employees where department_id = e.department_id);

# 자기 부서의 평균 급여도 출력
select last_name, salary, department_id,
round((select avg(salary) from employees where department_id = e.department_id)) 부서평균급여
from employees e;

# from 절의 서브쿼리
# 자신의 부서 평균급여보다 많은 급여 받는 사원 조회
# 부서별 평균급여를 from 절의 서브쿼리로 처리
select *
from employees e join (
	select department_id, avg(salary) avg_salary
    from employees
    group by department_id) da on e.department_id = da.department_id
where e.salary > da.avg_salary;

# hw2
#1. 부서번호, 부서명, 부서장사번, 부서장성명, 부서장입사일자를 출력하시오.
# - 단 부서장이 없으면 부서장없음으로 출력
select d.department_id 부서번호, department_name 부서명, ifnull(d.manager_id,'부서장없음') 부서장사번, 
ifnull(concat(e.first_name, e.last_name), '부서장없음') 부서장성명, ifnull(e.hire_date, '부서장없음') 부서장입사일자
from departments d left join employees e
on d.manager_id = e.employee_id;

 -- 정답 
select d.department_id 부서번호, department_name 부서명, ifnull(d.manager_id,'부서장없음') 부서장사번, 
ifnull(concat(e.first_name, e.last_name), '부서장없음') 부서장성명, ifnull(e.hire_date, '부서장없음') 부서장입사일자
from employees e right join departments d 
on e.employee_id = d.manager_id;

# 2. 자신의 관리자보다 먼저 입사한 직원의 사번, 성명, 입사일자, 관리자입사일자를 출력하시오.
select e.employee_id 직원사번, concat(e.first_name, e.last_name) 성명, e.hire_date 입사일자, e.hire_date 관리자입사일자
from employees e, employees m 
where e.manager_id = m.employee_id and e.hire_date < m.hire_date;

 -- 정답 
select e.employee_id 직원사번, concat(e.first_name, e.last_name) 성명, e.hire_date 입사일자, e.hire_date 관리자입사일자
from employees e join employees m
on e.manager_id = m.employee_id
where e.hire_date < m.hire_date;

# 3. Seattle에 근무하는 직원의 사번, 성명, 입사일자, 부서번호, 부서명을 출력
# - 단 서브쿼리로 합니다.
select e.employee_id 직원사번, concat(first_name, last_name) 성명, e.hire_date 입사일자, da.department_id 부서번호, da.department_name 부서명
from employees e join (
	select d.department_id, d.department_name
    from departments d, locations l
	where l.location_id = d.location_id and l.city = 'Seattle'
	) da on e.department_id = da.department_id;

-- 정답 
select employee_id 직원사번, concat(first_name, last_name) 성명, hire_date 입사일자, department_id 부서번호, (select department_name from departments where department_id = e.department_id) 부서명
from employees e 
where department_id in
	(
		select department_id
        from departments
        where location_id in (select location_id
								from locations
								where city = 'Seattle'
							  )
    );
    
# 인덱스
show indexes from employees;
# k로 시작되는 이름을 가진 사원 조회
# 전체를 불러온다 왜? 인덱스가 없어서
select * 
from employees
where last_name like 'K%';
create index emp_last_name_idx on employees(last_name);
drop index emp_last_name_idx on employees;

