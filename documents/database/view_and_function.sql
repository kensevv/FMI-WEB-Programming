create view contact_info
as
select ua.user_id, cc.contact_id, cc.email, cc.name, cc.photo, pn.phone_id, pn.phone_number, ad.address_id, ad.country, ad.city, ad.zip_code, ad.street   
from user_account ua, contact cc, phone_number pn, address ad
where cc.user_id = ua.user_id
and ( cc.address_id = ad.address_id or cc.address_id is null)
and pn.contact_id = cc.contact_id;

create function user_contact_info(p_user_id integer)
returns refcursor as $$
declare 
	ref refcursor;
begin
	open ref for select * from cotnact_info where user_id = p_user_id;
	return ref;	
end;
$$
language plpgsql;

