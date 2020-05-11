package com.leonardo.verifications;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.leonardo.init.Common;
import com.leonardo.init.SeleniumInit;
import com.leonardo.pages.Leonardo_mainpage;

public class Leonardo extends Leonardo_mainpage {

	public Leonardo() {
		super(null);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Leonardo Web Automation Suite
	 * 
	 * @throws InterruptedException
	 */
	// for login

	/**
	 * TC-3 Verify login functionality with valid credentials
	 * 
	 */

	@Test
	public void Verify_Login_with_valid_Details() {

		Login_with_valid_Details();

	}

	/**
	 * TC-1 : verify_Request_corporate_account_here_with_valid_details
	 * 
	 */

	@Test
	public void verify_Request_corporate_account_here_with_valid_details() {
		Request_corporate_account_with_valid_details();

	}

	/**
	 * TC-2 : verify_Request_corporate_account_here_with_blank_details
	 * 
	 */

	@Test
	public void verify_Request_corporate_account_form_with_blankspaces() {
		Request_corporate_account_with_blank_spaces();

	}

	// div[@name='first_name']

	/**
	 * TC-4 Verify login functionality with Invalid details and blank spaces
	 * 
	 */

	@Test
	public void Verify_login_with_invalid_details_blank_spaces() {
		Login_with_invalid_data();
	}

	/**
	 * TC-7 Remember My Username
	 * 
	 */
	@Test
	public void Verify_Remember_Username() {
		Remember_Username();

	}

	/**
	 * TC-8 TC-9 TC-10 Verify the Property Task
	 * 
	 */
	@Test
	public void Verfiy_PropertyTasks() {
		Login_with_valid_Details();
		Property_task();

	}

	/**
	 * TC-11 Edit created task from action items
	 * 
	 */

	@Test
	public void Verify_Updated_PropertyTask() {
		Login_with_valid_Details();
		Update_Created_PropertyTask();
	}

	/**
	 * TC-12 Edit the created task with blank spaces
	 * 
	 */
	@Test
	public void Verify_Edit_Created_task_with_blank_spaces() {

		Login_with_valid_Details();
		Edit_Created_task_with_blank_spaces();

	}

	/**
	 * TC-13 Verify clone created task functionality with all validations in
	 * Templates
	 * 
	 */

	@Test
	public void Verify_clone_created_task_functionality_with_all_validations_in_Templates() {
		Login_with_valid_Details();
		clone_created_task_functionality_with_all_validations_in_templates();
	}

	/**
	 * TC-14 Verify Delete Template with all child and without all child templates
	 * 
	 */
	@Test
	public void Verify_Delete_Template_with_all_child_and_without_all_child_templates() {
		Login_with_valid_Details();
		Delete_Template_with_all_child_and_without_all_child_templates();
	}

	/**
	 * TC-15 Verify Edit Property Tasks functionality
	 * 
	 */
	@Test
	public void Verify_Edit_Property_task_functionality() {
		Login_with_valid_Details();
		Edit_Property_task();

	}

	/**
	 * TC-16 To verify Edit Property Tasks with only blank spaces
	 * 
	 */
	@Test
	public void Verfiy_Edit_Property_Tasks_with_only_blankspaces() {
		Login_with_valid_Details();
		Edit_Property_task();
		Edit_Property_task_with_blankspaces();
	}

	/**
	 * TC-17 To To verify Change Priority, change Recurrence, Assign user and
	 * Deactivate Template functionality in Property Tasks
	 * 
	 */
	@Test
	public void Verify_Change_Priority_Recurrence_Assign_user_and_deactivate_Template_functionality_in_Property_Tasks() {
		Login_with_valid_Details();
		Proprty_task_Template_option();

	}

	/**
	 * TC-18
	 * To_verify_Leaveanote_Assign_Vendor_Assign_user_Snooze_this_task_Cannot_Do_Tasks_functionality_in_PropertyTasks
	 * 
	 * 
	 */
	@Test
	public void To_verify_Leaveanote_Assign_Vendor_Assign_user_Snooze_this_task_Cannot_Do_Tasks_functionality_in_PropertyTasks() {
		Login_with_valid_Details();
		Property_task_option();

	}

	/**
	 * TC-19 To_verify_Current_and_Past_due_tasks_functionality_in_propertytasks
	 * 
	 * 
	 */
	@Test
	public void To_verify_Current_and_Past_due_tasks_functionality_in_propertytasks() {
		Login_with_valid_Details();
		Pastdue_Current_tasks();

	}

	/**
	 * TC-20 To_ TC-19
	 * To_verify_Current_and_Past_due_tasks_functionality_in_propertytasks
	 * 
	 * 
	 */
	@Test
	public void verify_Completetask_functionality_in_propertytasks() {
		Login_with_valid_Details();
		Completetask_functionality_in_property_tasks();

	}

	@Test
	public void verify_Add_new_unit_workflow_functionality() {
		Login_with_valid_Details();
		Add_new_unit_workflow_functionality();

	}

	@Test
	public void Verify_Assign_user_functionality_in_Unit_workflow_template_with_all_validations() {
		Login_with_valid_Details();
		Unittaskworkflow_add_verificaiton_inList();
		AssginUser_in_Unittask();
	}

	@Test
	public void Verify_Leave_anote_functionality_in_unit_workflow_tasks_with_all_validations() {
		Login_with_valid_Details();
		Unittaskworkflow_add_verificaiton_inList();
		Leave_note_functionality_in_unit_workflow_tasks_with_all_validations();
	}

	@Test
	public void Verify_Assign_User_functionality_in_unit_workflow_tasks_with_all_validations() {
		Login_with_valid_Details();
		Unittaskworkflow_add_verificaiton_inList();
		Assign_User_functionality_in_unit_workflow_tasks_with_all_validations();
	}

	@Test
	public void verify_Cannot_do_functionality_in_unit_workflow_tasks_with_all_validations() {
		Login_with_valid_Details();
		Unittaskworkflow_add_verificaiton_inList();
		Cannot_do_functionality_in_unit_workflow_tasks_with_all_validations();
	}

	@Test
	public void task_delete() {
		Login_with_valid_Details();
		remove_task();
	}

	@Test
	public void Verify_Complate_task_functionality_in_unit_workflow_tasks() {
		Login_with_valid_Details();
		Unittaskworkflow_add_verificaiton_inList();
		Complate_task_functionality_in_unit_workflow_tasks();
	}

	@Test
	public void Verify_dynamic_form_functionality_in_Unit_workflow_tasks() {
		Login_with_valid_Details();
		dynamic_form_functionality_in_Unit_workflow_tasks();

	}

	@Test
	public void Verify_Clear_dynamic_form_fields_functionality_in_Unit_workflow_tasks() {
		Login_with_valid_Details();
		Clear_dynamic_form_fields_functionality_in_Unit_workflow_tasks();
	}

	@Test
	public void verify_Finish_dynamic_form_functionality_in_Unit_workflow_tasks_with_all_validations() {
		Login_with_valid_Details();
		Finish_Dynamic_Form();

	}

	@Test
	public void verify_Print_dynamic_form_functionality_in_Unitworkflow_tasks_with_all_validations() {
		Login_with_valid_Details();
		dynamic_form_functionality_in_Unit_workflow_tasks();
		print_Dynamicform();
	}

	@Test
	public void Verify_Undo_tasks_from_completed_section_in_unit_workflow_tasks() {
		Login_with_valid_Details();
		Unittaskworkflow_add_verificaiton_inList();
		Complate_task_functionality_in_unit_workflow_tasks();
		Undo_task_from_completed_sectoin_in_unitworkflow();
	}

	@Test
	public void verfiy_the_Define_workflow_functionality() {
		Login_with_valid_Details();
		Define_Workflow();
	}

	@Test
	public void verfiy_Launch_Unit_workflow_funcitonality() {
		Login_with_valid_Details();

		Launch_workflow();
	}
	@Test
	public void To_verify_the_Define_workflow_with_dymamic_form()
	{
		Login_with_valid_Details();
		Defineworkflow_with_Dynamic_form();
	}
	@Test
	public void To_verfify_the_Edit_Delete_fucitonalities_for_Defined_workflow()
	{
		Login_with_valid_Details();
		Edit_Delete_Funcitonality_Workflowtask();
	}
	@Test
	public void Verfiy_Fixed_date_recurrance_in_workspace() throws ParseException
	{
		Login_with_valid_Details();
		Add_task_with_fixed_date_recurrance();
	}
	
	@Test
	public void To_verfiy_On_Demand_Instuction_topics()
	{
		Login_with_valid_Details();
		On_Demand_instruction_topics();
	}
	@Test
	public void Add_On_demand_category_in_demand_instruction_library()
	{
		Login_with_valid_Details();
		Add_categories_OnDemand_instruction();
	}
	@Test
	public void Edit_Delete_created_on_Demand_category_from_list()
	{
		Login_with_valid_Details();
		Edit_Delete_Created_category_OnDemandinsturction();
	}
	@Test
	public void On_Demand_instruction_Addondemand_Subcategory()
	{
		Login_with_valid_Details();
		Add_OnDemand_Subcategory();
	}
}
