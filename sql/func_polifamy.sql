-- overlappingmarriage

-- drop procedure poligamy;

delimiter //
create procedure poligamy(idpersona int)
begin
	select
		*
	from
		relation as rel, relation as old
	where
		rel.type='marriage' and old.type='marriage'
		and 
		(rel.idp1=id or rel.idp2=idpersona)
		and
		(old.idp1=idpersona or old.idp2=idpersona)
		and
		rel.id <> old.id
		and
		(
		(
		rel.beginning between old.beginning and 
		if(old.ending is null, now(), old.ending)
		or
		if(rel.ending is null, now(), rel.ending) 
		between old.beginning and 
		if(old.ending is null, now(), old.ending)
		)
		or
		(
		old.beginning between rel.beginning and 
		if(rel.ending is null, now(), rel.ending)
		or
		if(old.ending is null, now(), old.ending) 
		between rel.beginning and 
		if(rel.ending is null, now(), rel.ending)
		)
		);
end
//
